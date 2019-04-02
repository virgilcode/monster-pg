package jdk.instance;

/**
 * @author Starstar Sun
 * @date 2019/2/20
 * @Description:
 **/
public class Dog1 implements Animal1 {


    public static void main(String[] args){
        Dog1 dog1=new Dog1();
        System.out.println(dog1 instanceof Dog1);
        System.out.println(dog1 instanceof Animal1);
        System.out.println(dog1.getClass().isAssignableFrom(Dog1.class));
        System.out.println(dog1.getClass().isAssignableFrom(Dog.class));
        System.out.println(dog1.getClass().isAssignableFrom(Animal.class));
        System.out.println(dog1.getClass().isAssignableFrom(Animal1.class));
    }
}
