package org.virgil.proxy;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.virgil.service.OrderService;
import org.virgil.service.UserService;
import org.virgil.service.impl.UserServiceImpl;

import java.lang.reflect.Method;

/**
 * @author Starstar Sun
 * @date 2018/8/3 11:53
 * @Description:
 **/
public class ProxyMain {

//    public void test() {
//        System.out.println("hello world");
//    }
//
//    public static void main(String[] args) {
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(ProxyMain.class);
//        enhancer.setCallback(new MethodInterceptor() {
//            @Override
//            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
//                System.out.println("before method run...");
//                Object result = proxy.invokeSuper(obj, args);
//                System.out.println("after method run...");
//                return result;
//            }
//        });
//        ProxyMain sample = (ProxyMain) enhancer.create();
//        sample.test();
//    }

    public static void main(String[] args) {
        //代理文件写在本地
//        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/sunvirgil/virgil/work/monster-pg/pg-web/pg");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);
        enhancer.setCallback(new CglibProxyIntercepter());
        UserService userService = (UserService) enhancer.create();
        userService.a();
    }
}
