package org.example.service.implementation;

import com.test.common.bean.Result;
import com.test.common.enums.CodeEnum;
import org.example.entity.User;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImplementation implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Result<User> register(User user) {
        Result<User> result = new Result<>();
        User getUser = userRepository.findByUsername(user.getUsername());
        if (getUser != null) {
            result.error(CodeEnum.SYSTEM_ERROR.getCode(), "Username already exists");
        }
        user.setPassword(user.getPassword());
        userRepository.save(user);
        result.success(CodeEnum.SUCCESS.getCode(), user, "Registration Success!");
        return result;
    }

    @Override
    public Result<User> login(User user) {
        return null;
    }

    @Override
    public Result<User> update(User user) throws Exception {
        return null;
    }
}
