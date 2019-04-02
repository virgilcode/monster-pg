package consul;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.kv.model.PutParams;
import com.ecwid.consul.v1.session.model.NewSession;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * @author Starstar Sun
 * @date 2018/8/7 18:03
 * @Description:
 **/
@Slf4j
public class ConsulLock {

    private static final String prefix = "/lock";
    private ConsulClient consulClient;
    private String sessionName;
    private String sessionId = null;
    private String lockKey;

    public ConsulLock(ConsulClient consulClient, String sessionName, String lockKey) {
        this.consulClient = consulClient;
        this.sessionName = sessionName;
        this.lockKey = lockKey;
    }

    /**
     * 同步锁 是否阻塞
     *
     * @param block
     * @return
     */
    public boolean lock(boolean block) {
        if (sessionId != null) {
            throw new RuntimeException(sessionId + " - Already locked!");
        }
        sessionId = createSession(sessionName);
        while (true) {
            PutParams params = new PutParams();
            params.setAcquireSession(sessionId);
            if (consulClient.setKVValue(lockKey, "lock:" + LocalDateTime.now(), params).getValue()) {
                return true;
            } else if (block) {
                continue;
            } else {
                return false;
            }
        }
    }

    /**
     * 释放锁
     */
    public boolean unlock() {
        PutParams params = new PutParams();
        params.setReleaseSession(sessionId);
        Boolean value = consulClient.setKVValue(lockKey, "unlock:" + LocalDateTime.now(), params).getValue();
        consulClient.sessionDestroy(sessionId, null);
        return value;
    }

    /**
     * 创建Session
     */
    private String createSession(String sessionName) {
        NewSession newSession = new NewSession();
        newSession.setName(sessionName);
        return consulClient.sessionCreate(newSession, null).getValue();
    }

    static class LockRunner implements Runnable {
        private int flag;

        public LockRunner(int flag) {
            this.flag = flag;
        }


        @Override
        public void run() {
            ConsulLock lock = new ConsulLock(new ConsulClient(), "lock-session", "lock-key");
            try {
                if (lock.lock(true)) {
                    log.info("Thread " + flag + " start!");
                    Thread.sleep(new Random().nextInt(3000));
                    log.info("Thread " + flag + " end!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new LockRunner(1)).start();
        new Thread(new LockRunner(2)).start();
        new Thread(new LockRunner(3)).start();
        new Thread(new LockRunner(4)).start();
        new Thread(new LockRunner(5)).start();
        Thread.sleep(200000L);
        
    }

}
