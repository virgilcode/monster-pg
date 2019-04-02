package org.virgil.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Repository;
import org.virgil.model.Order;

import java.util.List;

/**
 * @author Starstar Sun
 * @date 2018/7/3016:23
 * @Description:
 **/
public interface OrderMapper extends BaseMapper<Order> {

    List<Order> findAll();
}
