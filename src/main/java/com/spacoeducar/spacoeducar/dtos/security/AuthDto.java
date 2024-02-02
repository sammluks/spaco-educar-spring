package com.spacoeducar.spacoeducar.dtos.security;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
	private String password;
}
