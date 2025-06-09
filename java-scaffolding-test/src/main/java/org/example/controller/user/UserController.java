package org.example.controller.user;

import com.test.common.api.ServiceRs;
import com.test.common.api.ServiceRsBuilder;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.controller.user.bean.RegisterUserRq;
import org.example.service.user.UserService;
import org.example.service.user.bean.RegisterUserRs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@Tag(name = "User", description = "User Management API")
public class UserController {
    @Autowired
    private UserService service;

    @Operation(summary = "Register User", description = "Register a new user")
    @PostMapping(value = "/register")
    public ServiceRs<RegisterUserRs> registerUser(@RequestBody @Valid RegisterUserRq rq) {
        return ServiceRsBuilder.success(service.registerUser(rq));
    }

    @GetMapping("/get")
    public String getUser() {
        return "User details";
    }

}
