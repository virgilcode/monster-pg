package jdk.ali.loadbalance;

/**
 * @author Starstar Sun
 * @date 2019/3/6
 * @Description:
 **/
public interface HashStrategy {

    int getHashCode(String origin);

}
