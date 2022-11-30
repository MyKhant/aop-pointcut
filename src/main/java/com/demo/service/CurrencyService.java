package com.demo.service;

import com.demo.annotation.Intransaction;
import com.demo.annotation.Secured;
import com.demo.ds.CurrencyId;
import org.springframework.stereotype.Component;

@Component("currency") @Secured
public class CurrencyService {
    protected int changeCurrency(int amount){
        return amount;
    }
    @Intransaction
    void changeCurrency(int amount, int transferAmount){
        changeCurrency(200);
    }
    public String getLongCurrencyName(CurrencyId currencyId){
        if (currencyId.equals(CurrencyId.US)) {
            return "USA";
        }else throw new IllegalArgumentException();
    }
    public String getLongCountryName(CurrencyId currencyId){
        return switch (currencyId){
            case EURO -> "Euro";
            case US -> "Us";
            default -> "Bogus";
        };
    }
}
