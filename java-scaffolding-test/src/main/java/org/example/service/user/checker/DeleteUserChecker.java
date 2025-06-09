package org.example.service.user.checker;

import com.test.common.exception.BusinessException;
import org.example.controller.user.bean.DeleteUserRq;
import org.example.service.user.enums.UserServiceEnum;
import org.springframework.stereotype.Component;

@Component
public class DeleteUserChecker extends UserServiceBaseChecker {

    /**
     * 檢查用戶刪除請求的合法性
     */
    public void validateDeleteUserRequest(DeleteUserRq rq) {
        String username = rq.getUsername();

        Boolean userExists = super.getUserByUserName(username);
        if (!userExists) {
            throw new BusinessException(UserServiceEnum.USER_NOT_EXISTS, UserServiceEnum.USER_NOT_EXISTS.message);
        }
    }
}
