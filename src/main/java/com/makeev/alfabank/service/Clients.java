package com.makeev.alfabank.service;

import com.makeev.alfabank.Config;
import com.makeev.alfabank.clients.Currency;
import com.makeev.alfabank.clients.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Clients {

    @Autowired
    private Currency currency;
    @Autowired
    private Gif gif;
    @Autowired
    private Config config;

    public Double getRate(String name){
        return currency.getEx(config.getRatesApiKey(),config.getBaseCurrency()).getRates().get(name);
    }

    public Double getRate(String name, String date){
        return currency.getTime(date,config.getRatesApiKey(),config.getBaseCurrency()).getRates().get(name);
    }

    public String getGif(String tag){
        return "<iframe src=\"" +
                gif.getGif(config.getGifApiKey(), tag).toString() +
                "\" width=\"480\" height=\"480\"  frameBorder=\"0\" class=\"giphy-embed\" allowFullScreen></iframe";
    }

}
