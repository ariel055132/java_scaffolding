package org.example.service.user.checker;

import com.test.common.exception.BusinessException;
import org.example.controller.user.bean.UpdateUserRq;
import org.example.service.user.enums.UserServiceEnum;
import org.springframework.stereotype.Component;

@Component
public class UpdateUserChecker extends UserServiceBaseChecker {
    public void validateUpdateUserRequest(UpdateUserRq request) {
        String username = request.getUsername();

        Boolean userExists = super.getUserByUserName(username);
        if (!userExists) {
            throw new BusinessException(UserServiceEnum.USER_NOT_EXISTS, UserServiceEnum.USER_NOT_EXISTS.message);
        }
    }
}
