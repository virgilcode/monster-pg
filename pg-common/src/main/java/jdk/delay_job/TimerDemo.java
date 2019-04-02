package jdk.delay_job;

import lombok.extern.slf4j.Slf4j;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Starstar Sun
 * @date 2018/12/18
 * @Description:
 **/
@Slf4j
public class TimerDemo {

    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                log.info("" + System.currentTimeMillis());
                System.out.println("task do...");
            }
        };

        System.out.println(1<<1);
        System.out.println(1>>1);

//        timer.schedule(timerTask, 1000);
        log.info("" + System.currentTimeMillis());
        timer.schedule(timerTask,4000,2000);
        timer.scheduleAtFixedRate(timerTask,4000,2000);
    }
}
