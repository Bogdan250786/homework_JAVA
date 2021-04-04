package com.ISG.paramud.SpringDemoApp.demo;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Topic {
    
    private Long id;
    private String name;
    private String theme;
    LocalDate date;
    
    public Topic(Long id, String name, String theme, LocalDate date) {
        this.id = id;
        this.name = name;
        this.theme = theme;
        this.date = date;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getTheme() {
        return theme;
    }
    
    public void setTheme(String theme) {
        this.theme = theme;
    }
    
    public LocalDate getDate() {
        return date;
    }
    
    public void setDate(LocalDate date) {
        this.date = date;
    }
}
