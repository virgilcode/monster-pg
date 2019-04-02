package org.virgil.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.virgil.mapper.UserMapper;
import org.virgil.model.User;
import org.virgil.service.UserService;

/**
 * @author Starstar Sun
 * @date 2018/7/3016:56
 * @Description:
 **/
//@Service
public class UserServiceImpl implements UserService {


    @Override
    public void a() {
        this.b();
        System.out.println("this is a");
    }

    @Override
    public void b() {
        System.out.println("this is b");
    }
}
