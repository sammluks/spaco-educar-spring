package com.spacoeducar.spacoeducar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spacoeducar.spacoeducar.dtos.LoginResponseDto;
import com.spacoeducar.spacoeducar.dtos.RegisterDto;
import com.spacoeducar.spacoeducar.dtos.security.AuthDto;
import com.spacoeducar.spacoeducar.infra.security.TokenService;
import com.spacoeducar.spacoeducar.model.User;
import com.spacoeducar.spacoeducar.repositories.UserRepository;



@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private UserRepository repository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthDto data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.getUsername(), data.getPassword());

        var auth = this.authManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDto(token));
    }


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterDto data) {
        if(this.repository.findByLogin(data.getUsername()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.getPassword());

        User user = new User(data.getUsername(), encryptedPassword, data.getName(), data.getEmail());

        this.repository.save(user);

        return ResponseEntity.ok().build();
    }
    
}
