package caffeine;

import com.alibaba.fastjson.JSON;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author Starstar Sun
 * @date 2018/10/8
 * @Description:
 **/
public class CaffeineDemo1 {

    @Test
    public void test1() {
        Cache<String, String> cache = Caffeine.newBuilder()
                .expireAfterWrite(1, TimeUnit.MINUTES)
                .maximumSize(100)
                .build();
        System.out.println(JSON.toJSONString(cache.getIfPresent("pg")));

        System.out.println(JSON.toJSONString(cache.get("pg", key -> key + "13")));
    }

}
