package org.virgil.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Starstar Sun
 * @date 2018/8/3 11:50
 * @Description:
 **/
public class CglibProxyIntercepter implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("before");
        Object obj = methodProxy.invokeSuper(o, objects);
//        Object obj = method.invoke(o, objects);
        System.out.println("after");
        return obj;
    }
}
