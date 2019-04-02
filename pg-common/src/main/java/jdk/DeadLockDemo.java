package jdk;

/**
 * @author Starstar Sun
 * @date 2019/3/2
 * @Description:
 **/
public class DeadLockDemo {

    public static void main(String[] args){
        Thread thread1=new Thread(new DeadLock(true));
        Thread thread2=new Thread(new DeadLock(false));
        thread1.start();
        thread2.start();
    }
}
class DeadLock implements Runnable{
    boolean lockFormer;
    static Object o1=new Object();
    static Object o2=new Object();

    public DeadLock(boolean lockFormer) {
        this.lockFormer = lockFormer;
    }

    @Override
    public void run() {
        if(lockFormer){
            synchronized (o1){
                System.out.println("t1 locked object1 require to lock object2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2){
                    System.out.println("t1 locked object2");
                }
            }
        }else{
            synchronized (o2){
                System.out.println("t2 locked object2 require to lock object1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1){
                    System.out.println("t2 locked object1");
                }
            }
        }
    }
}