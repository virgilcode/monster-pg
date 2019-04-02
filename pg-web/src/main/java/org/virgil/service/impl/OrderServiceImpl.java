package org.virgil.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.virgil.datasource.DataSource;
import org.virgil.mapper.OrderMapper;
import org.virgil.model.Order;
import org.virgil.service.OrderService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Starstar Sun
 * @date 2018/7/3016:54
 * @Description:
 **/
@Service("orderService")
@DataSource(value = DataSource.Source.source2)
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    @Transactional
    public List<Order> findAll() {
        this.test();
        return this.orderMapper.findAll();
    }

    @Override
    @Transactional
    public void test() {
        System.out.println("holy shit");
    }
}
