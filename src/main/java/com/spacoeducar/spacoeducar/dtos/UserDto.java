package com.spacoeducar.spacoeducar.dtos;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto implements Serializable{
    private Long id;
    private String name;
    private String cpf;
    private String email;
    private String password;
}
