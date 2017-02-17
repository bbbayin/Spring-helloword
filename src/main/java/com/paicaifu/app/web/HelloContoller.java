package com.paicaifu.app.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bayin on 2017/2/17.
 */
@RestController
public class HelloContoller {
    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }
}
