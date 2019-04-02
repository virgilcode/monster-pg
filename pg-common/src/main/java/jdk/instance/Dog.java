package jdk.instance;

/**
 * @author Starstar Sun
 * @date 2019/2/20
 * @Description:
 **/
public class Dog extends Animal {

    public static void main(String[] args){
        Dog dog=new Dog();
        System.out.println(dog instanceof Dog);
        System.out.println(dog instanceof Animal);
        System.out.println(dog.getClass().isAssignableFrom(Dog.class));
        System.out.println(dog.getClass().isAssignableFrom(Animal.class));
        System.out.println(dog.getClass().isAssignableFrom(Animal1.class));
        System.out.println(dog.getClass().isAssignableFrom(Dog1.class));
    }
}
