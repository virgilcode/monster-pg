package org.virgil.datasource;

import java.lang.annotation.*;

/**
 * @author Starstar Sun
 * @date 2018/7/3116:10
 * @Description:
 **/
@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {

    Source value() default Source.source1;

    enum Source {
        source1,
        source2
    }
}
