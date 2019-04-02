package spi;

/**
 * @author Starstar Sun
 * @date 2018/12/13
 * @Description:
 **/
public class EnglishSayService implements SayService {
    @Override
    public void say() {
        System.out.println("say in english");
    }
}
