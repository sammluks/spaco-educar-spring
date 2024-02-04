package com.spacoeducar.spacoeducar.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Subject discipline;
    
    @Column(nullable = false)
    private String description;
    
    @Column(nullable = false)
    private String author;
    
    @Column(nullable = false)
    private double price;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Grade grade;
    
    public Material(String title, Subject discipline, String description, String author, double price) {
        this.title = title;
        this.discipline = discipline;
        this.description = description;
        this.author = author;
        this.price = price;
    }
}
