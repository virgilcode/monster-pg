package jdk.delay_job;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;

import java.util.concurrent.TimeUnit;

/**
 * @author Starstar Sun
 * @date 2018/9/12
 * @Description:
 **/
public class HashTimeWheel {

    public static void main(String[] args) throws InterruptedException {
        HashedWheelTimer timer = new HashedWheelTimer(24, TimeUnit.SECONDS, 12);
        TimerTask task1 = new TimerTask() {
            @Override
            public void run(Timeout timeout) throws Exception {
                System.out.println(System.currentTimeMillis());
                System.out.println("task is running");
                Thread.sleep(1000);

            }
        };
        System.out.println(System.currentTimeMillis());
        timer.newTimeout(task1, 100, TimeUnit.MILLISECONDS);
        timer.start();
        Thread.currentThread().join();
    }
}
