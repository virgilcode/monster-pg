package jdk;

/**
 * @author Starstar Sun
 * @date 2018/7/3111:42
 * @Description:
 **/
public class LoaderTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader classLoader = LoaderTest.class.getClassLoader();
        //不会初始化静态块
//        classLoader.loadClass("jdk.JdkHello");

        //会初始化静态块
//        Class.forName("jdk.JdkHello");

        //可以指定是否初始化静态块
        Class<?> hello = Class.forName("jdk.JdkHello", true, classLoader);
        JdkHello o = (JdkHello) hello.newInstance();
        o.hello();


    }
}
