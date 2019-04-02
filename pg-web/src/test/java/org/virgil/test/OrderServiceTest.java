package org.virgil.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.virgil.model.Order;
import org.virgil.service.OrderService;

import java.util.List;

/**
 * @author Starstar Sun
 * @date 2018/7/3016:57
 * @Description:
 **/
public class OrderServiceTest extends TestBase {

    @Autowired
    private OrderService orderService;

    @Test
    public void test1() {
        Order order = new Order();
        order.setOrder_id(1);
        order.setStatus("test22222");
        order.setUser_id(1);
        orderService.insert(order);
    }

    @Test
    public void testAll() {
        List<Order> orders = orderService.findAll();
        System.out.println(JSON.toJSONString(orders));
        StringBuffer sb1 = new StringBuffer();
        StringBuilder sb2 = new StringBuilder();
    }


}
