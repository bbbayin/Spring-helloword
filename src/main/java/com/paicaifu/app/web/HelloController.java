package com.paicaifu.app.web;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.text.DecimalFormat;

/**
 * Created by bayin on 2017/2/17.
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String indexxxx(@RequestParam("a") int a, @RequestParam("b") int b) {
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

    @RequestMapping("/cheng")
    public String cheng(@RequestParam("a") String a, @RequestParam("b") String b) {
        double a1, b1;
        DecimalFormat df = new DecimalFormat("######0.0000");
        try {
            a1 = Double.parseDouble(a);
            b1 = Double.parseDouble(b);
        } catch (Exception e) {
            return "参数传递错误";
        }
        double c = a1 * b1;
        return String.valueOf(df.format(c));
    }

    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("host", "http://blog.didispace.com");
        return "calculator";
    }
}
