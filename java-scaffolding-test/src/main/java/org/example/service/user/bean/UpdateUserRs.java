package org.example.service.user.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UpdateUserRs {

    private long id;

    @Schema(description = "用戶姓名", example = "Adrian")
    private String username;
}
