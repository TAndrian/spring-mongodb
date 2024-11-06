package com.learning.spring_mongo.controller.resouce.v1;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.learning.spring_mongo.controller.Paths.BASE_URL;

@RestController
@RequestMapping(
        path = BASE_URL,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class HelloWorld {
    @GetMapping("/hello")
    public String helloWord(){
        return "hello world";
    }
}
