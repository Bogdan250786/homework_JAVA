package com.ISG.paramud;

import java.io.*;
import java.util.Date;

public class BookItem implements Serializable {
    private static final long serialVersionUID = 1000L;
    private final long itemId;
    String name;
    String phone;
    String email;
    
    
    BookItem(String name, String phone, String email) {
        this.itemId = new Date().getTime();
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
    
    public String getName() {
        return name;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public String getEmail() {
        return email;
    }
    
    @Override
    public String toString() {
        return "{" + "id='" + itemId + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}' + "\n";
    }
}

