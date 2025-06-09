package org.example.controller.user.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class RegisterUserRq {
    @NotBlank
    @Schema(description = "用戶姓名", example = "Adrian")
    @NotBlank(message = "用戶姓名不能為空")
    @Size(max = 20, message = "用戶姓名不能超過20個字符")
    private String username;

    @NotBlank
    @Schema(description = "用戶密碼")
    @NotBlank(message = "用戶密碼不能為空")
    @Size(min = 14, message = "用戶密碼不能少於14個字符")
    private String password;
}
