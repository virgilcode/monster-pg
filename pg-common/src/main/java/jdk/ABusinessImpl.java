package jdk;

/**
 * @author Starstar Sun
 * @date 2019/2/11
 * @Description:
 **/
public class ABusinessImpl implements ABusiness {
    @Override
    public Object proceed() throws Throwable {
        System.out.println("proceed in ABusinessImpl");
        return null;
    }
}
