package jdk;

import com.alibaba.fastjson.JSON;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author Starstar Sun
 * @date 2018/8/15 17:44
 * @Description:
 **/
public class SortMapDemo {
    public static void main(String[] args) {
        SortedMap<Integer, String> map = new TreeMap();
        map.put(23, "aaa");
        map.put(21, "bbb");
        map.put(33, "ccc");
        map.put(44, "ddd");
        System.out.println(JSON.toJSONString(map));
//        System.out.println(map.lastKey());
//        System.out.println(map.firstKey());
        SortedMap<Integer, String> map2 = map.tailMap(2);
        System.out.println(map2.size());
        System.out.println(JSON.toJSONString(map2));
    }
}
