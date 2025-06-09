package org.example.service.user;

import com.test.common.api.EmptyRs;
import org.example.controller.user.bean.DeleteUserRq;
import org.example.controller.user.bean.RegisterUserRq;
import org.example.controller.user.bean.UpdateUserRq;
import org.example.entity.User;
import org.example.service.user.bean.RegisterUserRs;
import org.example.service.user.bean.UpdateUserRs;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    RegisterUserRs registerUser(RegisterUserRq s);

    UpdateUserRs updateUser(UpdateUserRq s);

    EmptyRs deleteUser(DeleteUserRq s);

    User getUser(long id);

    List<User> getAll();
}
