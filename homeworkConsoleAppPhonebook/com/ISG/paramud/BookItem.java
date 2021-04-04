package com.ISG.paramud;

import java.io.*;

enum ItemsType {NAME, PHONE, EMAIL}

public class BookItem implements Serializable {
    private static final long serialVersionUID = 1000L;
    private static int count = 1;
    private final int itemId;
    String name;
    String phone;
    String email;
    
    
    BookItem(ItemsType NAME, String name, ItemsType PHONE, String phone, ItemsType EMAIL, String email) {
        this.itemId = count;
        this.name = name;
        this.phone = phone;
        this.email = email;
        count++;
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

