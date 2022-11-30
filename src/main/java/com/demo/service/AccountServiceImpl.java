package com.demo.service;

import com.demo.annotation.Secured;
import org.springframework.stereotype.Component;

@Component
public class AccountServiceImpl implements AccountService{
    @Override
    public void create() {
        test();
        System.out.println("Account created.");
    }
    public void test(){
        System.out.println("Test");
    }
}
