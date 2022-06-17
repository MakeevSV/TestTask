package com.makeev.alfabank;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.makeev.alfabank.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api/v1")
public class Controller {

    @Autowired
    Service service;

   @GetMapping("course")
   public ResponseEntity getStatistic(@RequestParam String name) throws JsonProcessingException {
            return service.course(name);
        }


}


