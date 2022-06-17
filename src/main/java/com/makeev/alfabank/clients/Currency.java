package com.makeev.alfabank.clients;


import com.makeev.alfabank.clients.dto.Rate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "rates", url = "${config.ratesUrl}")

@Component
public interface Currency {

    @GetMapping("latest.json")
    Rate getEx(@RequestParam String app_id,
               @RequestParam String base);

    @GetMapping("historical/{date}.json")
    Rate getTime(@PathVariable String date,
                 @RequestParam String app_id,
                 @RequestParam String base);


}
