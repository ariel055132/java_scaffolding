package org.example.service.user.impl;

import com.test.common.api.EmptyRs;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.example.controller.user.bean.DeleteUserRq;
import org.example.controller.user.bean.RegisterUserRq;
import org.example.controller.user.bean.UpdateUserRq;
import org.example.entity.User;
import org.example.repository.UserRepository;
import org.example.service.user.UserService;
import org.example.service.user.bean.RegisterUserRs;
import org.example.service.user.bean.UpdateUserRs;
import org.example.service.user.checker.DeleteUserChecker;
import org.example.service.user.checker.RegisterUserChecker;
import org.example.service.user.checker.UpdateUserChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RegisterUserChecker registerUserChecker;

    @Autowired
    private UpdateUserChecker updateUserChecker;

    @Autowired
    private DeleteUserChecker deleteUserChecker;

    @Override
    public RegisterUserRs registerUser(@Valid RegisterUserRq s) {
        registerUserChecker.validateAccountName(s);
        User user = new User();
        user.setUsername(s.getUsername());
        user.setPassword(s.getPassword());

        User savedUser = userRepository.save(user);

        RegisterUserRs rs = new RegisterUserRs();
        rs.setId(savedUser.getId());
        rs.setUsername(savedUser.getUsername());
        return rs;
    }

    @Override
    public UpdateUserRs updateUser(UpdateUserRq s) {
        updateUserChecker.validateUpdateUserRequest(s);
        Optional<User> user = userRepository.findUserByUsername(s.getUsername());

        user.get().setUsername(s.getUsername());
        user.get().setPassword(s.getPassword());

        User updatedUser = userRepository.save(user.get());

        UpdateUserRs rs = new UpdateUserRs();
        rs.setId(updatedUser.getId());
        rs.setUsername(updatedUser.getUsername());
        return rs;
    }

    @Override
    public EmptyRs deleteUser(DeleteUserRq s) {
        deleteUserChecker.validateDeleteUserRequest(s);
        Optional<User> user = userRepository.findUserByUsername(s.getUsername());

        userRepository.delete(user.get());

        return new EmptyRs();
    }

    @Override
    public User getUser(long id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    @Override
    public List<User> getAll() {
        List<User> users = userRepository.findAll();
        return users;
    }
}
