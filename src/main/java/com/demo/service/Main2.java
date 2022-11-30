package com.demo.service;

import com.demo.ProjectConfig;
import com.demo.ds.CurrencyId;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ProjectConfig.class);
        context.registerShutdownHook();
        AccountService accountService = context.getBean(AccountService.class);
        accountService.create();
        accountService.test();

        CurrencyService currencyService = context.getBean(CurrencyService.class);
        currencyService.changeCurrency(100,100);
        currencyService.changeCurrency(200);
        currencyService.getLongCountryName(CurrencyId.EURO);
    }
}
