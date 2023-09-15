package com.KN.OrderManagementSystem.Exceptions;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(String s){
        super(s);
    }
}
