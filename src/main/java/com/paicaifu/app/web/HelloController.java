package com.paicaifu.app.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bayin on 2017/2/17.
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String index(@RequestParam("a") int a, @RequestParam("b") int b) {
        int c = a + b;
        return String.valueOf(a) + "+" + String.valueOf(b) + "=" + String.valueOf(c);
    }

    @RequestMapping("/sqrt")
    public String sqrt(@RequestParam("a") String a) {
        double result, temp;
        try {
            temp = Double.parseDouble(a);
        } catch (Exception e) {
            return "参数传递错误: " + a;
        }
        if (Double.parseDouble(a) < 0) return "不能传负数: " + a;
        result = Math.sqrt(temp);

        return String.valueOf(result);
    }
}
