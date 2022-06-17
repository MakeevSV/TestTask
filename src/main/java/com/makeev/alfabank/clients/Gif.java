package com.makeev.alfabank.clients;

import com.makeev.alfabank.Config;
import com.makeev.alfabank.clients.dto.GifObj;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "url", url = "${config.gifUrl}")
@Component
public interface Gif {


    @GetMapping("random")
    GifObj getGif(
                  @RequestParam String api_key,
                  @RequestParam String tag);

}
