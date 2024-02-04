package com.spacoeducar.spacoeducar.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/material")
public class MaterialController {

    @PostMapping(value = "/new", produces = "application/json")
    public ResponseEntity postMethodName(@RequestBody MaterialDto entity) {
        //TODO: process POST request
        
        return ResponseEntity.ok().build();
    }
    
}
