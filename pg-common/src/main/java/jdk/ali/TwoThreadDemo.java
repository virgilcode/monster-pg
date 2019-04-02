package jdk.ali;

/**
 * @author Starstar Sun
 * @date 2018/8/15 21:38
 * @Description:两个线程交替打印奇偶数1-100
 **/
public class TwoThreadDemo {

    private int start = 1;//打印的数
    private boolean flag = false;//用来区分奇偶的执行

    public static void main(String[] args) {
        TwoThreadDemo demoThread = new TwoThreadDemo();
        Thread thread1 = new Thread(new OuThread(demoThread));
        Thread thread2 = new Thread(new JiThread(demoThread));
        thread1.start();
        thread2.start();

    }

    public static class OuThread implements Runnable {

        private TwoThreadDemo number;

        public OuThread(TwoThreadDemo number) {
            this.number = number;
        }

        @Override
        public void run() {
            while (number.start <= 100) {
                synchronized (TwoThreadDemo.class) {
//                    System.out.println("偶数线程...");
                    if (number.flag) {
                        System.out.println("偶数" + number.start);
                        number.start++;
                        number.flag = false;
                        TwoThreadDemo.class.notify();
                    } else {
                        try {
                            TwoThreadDemo.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }
    }

    public static class JiThread implements Runnable {
        private TwoThreadDemo number;

        public JiThread(TwoThreadDemo number) {
            this.number = number;
        }

        @Override
        public void run() {
            while (number.start <= 100) {
                synchronized (TwoThreadDemo.class) {
//                    System.out.println("奇数线程...");
                    if (!number.flag) {
                        System.out.println("奇数" + number.start);
                        number.start++;
                        number.flag = true;
                        TwoThreadDemo.class.notify();
                    } else {
                        try {
                            TwoThreadDemo.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }
    }
}
