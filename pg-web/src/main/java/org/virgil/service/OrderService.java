package org.virgil.service;

import com.baomidou.mybatisplus.service.IService;
import org.virgil.model.Order;

import java.util.List;

/**
 * @author Starstar Sun
 * @date 2018/7/3016:54
 * @Description:
 **/
public interface OrderService extends IService<Order> {
    List<Order> findAll();

    void test();
}
