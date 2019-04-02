package jdk;

/**
 * @author Starstar Sun
 * @date 2019/2/11
 * @Description:
 **/
public class BusinessCallbackDemo {

    public static void main(String[] args) throws Throwable {
        BusinessCallbackDemo callbackDemo=new BusinessCallbackDemo();
        ABusinessImpl impl=new ABusinessImpl();
        callbackDemo.run(impl::proceed);
    }

    public void run(BusinessCallback callback) throws Throwable {
        callback.call();
    }

}
