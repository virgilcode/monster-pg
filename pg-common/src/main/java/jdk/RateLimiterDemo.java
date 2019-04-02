package jdk;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @author Starstar Sun
 * @date 2018/8/16 14:57
 * @Description:
 **/
public class RateLimiterDemo {

    public static void main(String[] args) {
        RateLimiter rateLimiter = RateLimiter.create(2);
        //支持预消费  第一次不需要等待
        System.out.println(rateLimiter.acquire(5));
        //为上一个请求买单，需等待补充5个令牌 5/2=2.5
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(rateLimiter.acquire(2));

//        System.out.println(rateLimiter.tryAcquire());
        //为上面的2个请求买单 2/2=1
        System.out.println(rateLimiter.acquire(1));


    }
}
