package jdk.ali.loadbalance;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Starstar Sun
 * @date 2019/3/6
 * @Description:
 **/
public class ConsistentHashLoadBalancer implements LoadBalancer {

    private HashStrategy hashStrategy = new JDKHashStrategy();
    private static int VIRTUAL_NODE_SIZE=10;
    private static String VIRTUAL_NODE_SUFFIX="&&";

    @Override
    public Server select(List<Server> servers, Invocation invocation) {
        int hashCode = hashStrategy.getHashCode(invocation.getHashKey());
        // can cache
        TreeMap<Integer, Server> rings = buildConsistentHashRing(servers);
        return find(rings,hashCode);
    }

    private Server find(TreeMap<Integer, Server> rings,int invocationHashCode){
        // 向右找到第一个key
        Map.Entry<Integer, Server> entry = rings.ceilingEntry(invocationHashCode);
        if(entry==null){
            // 想象成一个环，超过尾部则取第一个 key
            entry=rings.firstEntry();
        }
        return  entry.getValue();
    }

    private TreeMap<Integer,Server> buildConsistentHashRing(List<Server> servers){
        TreeMap<Integer,Server> virtualNodeRing=new TreeMap<>();
        for(Server server:servers){
            for(int i=0;i<VIRTUAL_NODE_SIZE;i++){
                virtualNodeRing.put(hashStrategy.getHashCode(server.getUrl()+VIRTUAL_NODE_SUFFIX+i),server);
            }
        }
        return virtualNodeRing;
    }
}
