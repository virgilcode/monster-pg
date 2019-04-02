package jdk.delay_job;

import com.alibaba.fastjson.JSON;

import java.util.Random;
import java.util.concurrent.DelayQueue;

/**
 * @author Starstar Sun
 * @date 2018/9/12
 * @Description:
 **/
public class DelayMessageJob {

    public static void main(String[] args) throws InterruptedException {
        DelayQueue<Message> delayQueue = new DelayQueue<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            // 1毫秒的时间
            Message message = new Message(i, "content" + i, random.nextInt(1000000));
            delayQueue.add(message);
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {
                    try {
                        Message message = delayQueue.take();
                        System.out.println(JSON.toJSONString(message));
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();

        Thread.currentThread().join();
    }
}
