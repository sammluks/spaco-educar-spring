package com.spacoeducar.spacoeducar.dtos;

import lombok.Data;

@Data
public class RegisterDto {
    String username;
    String password;
    String name;
    String email;
}
