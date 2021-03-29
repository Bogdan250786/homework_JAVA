package com.ISG.paramud.SpringDemoApp.demo;

import com.ISG.paramud.SpringDemoApp.demo.Logger;

//@Component
public class UnLoggedUser implements Logger {
   
    @Override
    public void log(){
        System.out.println("User is not logged");
    }
}
    
