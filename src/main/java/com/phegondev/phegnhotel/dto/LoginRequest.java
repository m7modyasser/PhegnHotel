package com.phegondev.phegnhotel.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.aspectj.bridge.Message;

@Data
public class LoginRequest {
    @NotBlank(message = "Email is required")
    private String email;
    @NotBlank(message = "Password is required")

    private String password;
}
