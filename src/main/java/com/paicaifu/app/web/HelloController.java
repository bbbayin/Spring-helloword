package com.paicaifu.app.web;

import com.paicaifu.app.web.exception.JsonResultException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.text.DecimalFormat;

/**
 * Created by bayin on 2017/2/17.
 */
@Controller
public class HelloController {
    @RequestMapping("/")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "Hello world,Spring");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }

    @RequestMapping("/sqrt")
    public String sqrt(@RequestParam("a") String a) throws Exception {
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
    public String cheng(@RequestParam("a") String a, @RequestParam("b") String b) throws JsonResultException {
        double a1, b1;
        a1 = Double.parseDouble(a);
        b1 = Double.parseDouble(b);
        double c = a1 * b1;
        return String.valueOf(c);
    }

    @RequestMapping("/json")
    public void jsonExcTest() throws JsonResultException{
        throw new JsonResultException("发生错误");
    }
}
