package jdk.ali.loadbalance;

/**
 * @author Starstar Sun
 * @date 2019/3/6
 * @Description:
 **/
public class JDKHashStrategy implements HashStrategy {
    @Override
    public int getHashCode(String origin) {
        return origin.hashCode();
    }
}
