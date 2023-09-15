package com.KN.OrderManagementSystem.Exceptions;

public class OrderLineNotFoundException extends RuntimeException{
    public OrderLineNotFoundException(String s){
        super(s);
    }
}
