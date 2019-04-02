package zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author Starstar Sun
 * @date 2018/7/3014:06
 * @Description:
 **/
public class ZookeeperClient {
    private static String host = "127.0.0.1:2181";
    private static int sessionTimeout = 10000;

    public static ZooKeeper getInstance() throws IOException, InterruptedException {
        final CountDownLatch signal = new CountDownLatch(1);
        ZooKeeper zooKeeper = new ZooKeeper(host, sessionTimeout, new Watcher() {
            public void process(WatchedEvent watchedEvent) {
                if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
                    signal.countDown();
                }
            }
        });
        signal.await(sessionTimeout, TimeUnit.MILLISECONDS);
        return zooKeeper;
    }

    public static String getHost() {
        return host;
    }

    public static void setHost(String host) {
        ZookeeperClient.host = host;
    }

    public static int getSessionTimeout() {
        return sessionTimeout;
    }

    public static void setSessionTimeout(int sessionTimeout) {
        ZookeeperClient.sessionTimeout = sessionTimeout;
    }
}
