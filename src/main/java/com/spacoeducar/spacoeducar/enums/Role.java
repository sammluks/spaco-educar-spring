package com.spacoeducar.spacoeducar.enums;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public enum Role {
    ADMIN(1, "administrador"),
    USER(2, "usuário");

    @Id
    private Integer id;
    private String description;

    Role(Integer id, String description) {
        this.id = id;
        this.description = description;
    }
}
