package spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author Starstar Sun
 * @date 2018/12/13
 * @Description:
 **/
public class SayMain {

    public static void main(String[] args){
        ServiceLoader<SayService> services = ServiceLoader.load(SayService.class);
        Iterator<SayService> iterator =services.iterator();
        while (iterator!=null&&iterator.hasNext()){
            SayService next = iterator.next();
            next.say();
        }
    }
}
