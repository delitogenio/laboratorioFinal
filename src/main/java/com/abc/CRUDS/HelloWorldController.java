package com.abc.CRUDS;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {


    @GetMapping("/hello")
    @ResponseBody
    public String helloWorld(){
        return "Hola Mundo";
    }
}
