package com.makeev.alfabank;

import com.makeev.alfabank.clients.Currency;
import com.makeev.alfabank.clients.dto.Rate;
import com.makeev.alfabank.exp.NotValidInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Utils {

    @Autowired
    Currency currency;
    @Autowired
    Config config;

    public Utils() {
    }

    public String checkInputRate(String name) throws NotValidInputException {
        Rate rate = currency.getEx(config.getRatesApiKey(),config.getBaseCurrency());
        if(rate.getRates().get(name.toUpperCase()) == null ){
            throw new NotValidInputException(name);
        }
        else {
            return name;
        }
    }

}
