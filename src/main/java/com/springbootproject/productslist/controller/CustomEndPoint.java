package com.springbootproject.productslist.controller;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="custom")
public class CustomEndPoint {
    @ReadOperation
    public String getCustom(){
        return "This is custom Endpoint";
    }
}
