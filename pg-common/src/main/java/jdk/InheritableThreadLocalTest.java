package jdk;

/**
 * @author Starstar Sun
 * @date 2018/9/3
 * @Description:
 **/
public class InheritableThreadLocalTest {


    public static ThreadLocal<Integer> threadLocal = new InheritableThreadLocal<>();


    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("MyThread = " + threadLocal.get());
        }
    }

    public static void main(String[] args) {
        threadLocal.set(100);
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println(threadLocal.get());
    }
}
