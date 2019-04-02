package spi;

/**
 * @author Starstar Sun
 * @date 2018/12/13
 * @Description:
 **/
public class ChineseSayService implements SayService {
    @Override
    public void say() {
        System.out.println("中文说");
    }
}
