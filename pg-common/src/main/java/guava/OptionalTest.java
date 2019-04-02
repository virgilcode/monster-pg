package guava;

import com.google.common.base.Optional;

import java.util.Set;

/**
 * @author Starstar Sun
 * @date 2019/2/20
 * @Description:
 **/
public class OptionalTest {
    public static void main(String[] args){
        OptionalTest optionalTest=new OptionalTest();
        optionalTest.test();
        System.out.println(OptionalTest.class.getName());
    }

    public void test(){
        Optional<Long> value = method();
        if(value.isPresent()){
            System.out.println("获得返回值: " + value.get());
        }else{
            System.out.println("获得给定值: " + value.or(-1L));
        }
        System.out.println("获得返回值 orNull: " + value.orNull());


        Optional<Long> valueNoNull = methodNoNull();
        if(valueNoNull.isPresent()==true){
            Set<Long> set=valueNoNull.asSet();
            System.out.println("获得返回值 set 的 size : " + set.size());
            System.out.println("获得返回值: " + valueNoNull.get());
        }else{
            System.out.println("获得返回值: " + valueNoNull.or(-12L));
        }

        System.out.println("获得返回值 orNull: " + valueNoNull.orNull());
    }

    private Optional<Long> method() {
        return Optional.fromNullable(null);
    }
    private Optional<Long> methodNoNull() {
        return Optional.fromNullable(15L);
    }
}
