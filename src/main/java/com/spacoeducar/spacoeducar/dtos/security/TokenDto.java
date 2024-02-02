package com.spacoeducar.spacoeducar.dtos.security;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
	private Boolean authenticated;
	private Date created;
	private Date expiration;
	private String accesToken;
	private String refreshToken;
}
