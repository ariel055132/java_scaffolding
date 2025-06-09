package org.example.service.user.checker;

import com.test.common.exception.BusinessException;
import org.example.controller.user.bean.RegisterUserRq;
import org.example.service.user.enums.UserServiceEnum;
import org.springframework.stereotype.Component;

@Component
public class RegisterUserChecker extends UserServiceBaseChecker{
    public void validateAccountName(RegisterUserRq request) {
        String username = request.getUsername();

        Boolean userExists = super.getUserByUserName(username);
        if (userExists) {
            throw new BusinessException(UserServiceEnum.USER_EXISTS, UserServiceEnum.USER_EXISTS.message);
        }
    }
}
