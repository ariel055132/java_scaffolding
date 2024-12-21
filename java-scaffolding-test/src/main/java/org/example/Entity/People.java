package org.example.Entity;

import com.test.common.validation.PasswordRule;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

@Data
public class People implements Serializable {
    @NotBlank
    @PasswordRule
    private String pwd;
}
