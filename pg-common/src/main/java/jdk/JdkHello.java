package jdk;

/**
 * @author Starstar Sun
 * @date 2018/7/3111:43
 * @Description:
 **/
public class JdkHello {

    static {
        System.out.println("jdk hello static code run");
    }

    public JdkHello() {
        System.out.println("jdk hello ");
    }

    public void hello() {
        System.out.println("say");
    }
}
