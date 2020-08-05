package com.fh;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("testController")
public class TestController {

    @RequestMapping("test")
    public String test(){
        System.out.println("hello 索大大");
        return "索大大";
    }

}
