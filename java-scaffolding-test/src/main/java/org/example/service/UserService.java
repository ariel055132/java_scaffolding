package org.example.service;

import com.test.common.bean.Result;
import org.example.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    Result<User> register(User user);

    Result<User> login(User user);

    Result<User> update(User user) throws Exception;

    //Result<User> isLogin(HttpSession session);
}
