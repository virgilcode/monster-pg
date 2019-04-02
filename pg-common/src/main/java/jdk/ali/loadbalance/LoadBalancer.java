package jdk.ali.loadbalance;

import java.util.List;

/**
 * @author Starstar Sun
 * @date 2019/3/6
 * @Description:
 **/
public interface LoadBalancer {
    Server select(List<Server> servers, Invocation invocation);
}
