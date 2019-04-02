package org.virgil.datasource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author Starstar Sun
 * @date 2018/7/3116:12
 * @Description:
 **/
@Component
@Aspect
public class MultiDataSourceAspect {

    @PostConstruct
    void init() {
        System.out.println("init MultiDataSourceAspect");
    }

    @Around("execution(* org.virgil.service..*.*(..))")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("aop start");

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Class<?> clazz = signature.getMethod().getDeclaringClass();
        System.out.println(clazz.getCanonicalName());
        if (clazz.isAnnotationPresent(DataSource.class)) {
            DataSource dataSource = clazz.getAnnotation(DataSource.class);
            System.out.println("aop:::::" + dataSource.value().name());
            if (dataSource == null) {
                MultiDataSource.setDataSourceKey(DataSource.Source.source1.name());
            } else {
                MultiDataSource.setDataSourceKey(dataSource.value().name());
            }
        }


        return joinPoint.proceed();
    }
}
