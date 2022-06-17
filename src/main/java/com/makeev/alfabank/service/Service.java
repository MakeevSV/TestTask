package com.makeev.alfabank.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.makeev.alfabank.Utils;
import com.makeev.alfabank.exp.NotValidInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private Clients clients;
    @Autowired
    Utils utils;

    public ResponseEntity course(String name) throws JsonProcessingException {
        String rateName;

        try {
            rateName = utils.checkInputRate(name).toUpperCase();
        } catch (NotValidInputException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad request. Try again");

        }


        double current = clients.getRate(rateName);
        double yesteday = clients.getRate(rateName, yesterdayDate());

        if(current>yesteday){
             return ResponseEntity.status(HttpStatus.OK).body(clients.getGif("rich"));
        } else {
             return ResponseEntity.status(HttpStatus.OK).body(clients.getGif("broke"));
        }


    }

    public String yesterdayDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE,-1);
        return dateFormat.format(cal.getTime()).toString();
    }



}
