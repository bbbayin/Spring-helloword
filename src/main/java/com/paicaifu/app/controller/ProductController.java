package com.paicaifu.app.controller;

import com.paicaifu.app.domain.ResultBean;
import com.paicaifu.app.domain.product.Product;
import com.paicaifu.app.domain.product.ProductRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * Created by bayin on 2017/2/24.
 */
@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private ProductRepository repository;


    @ApiOperation(value = "插入新产品")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ResultBean<String, Product> create(@RequestParam(value = "name") String name,
                                              @RequestParam(value = "rate") String rate,
                                              @RequestParam(value = "desc") String desc){
        Product product = new Product(name, desc, rate);
        Object save = repository.save(product);
        ResultBean<String, Product> bean = new ResultBean<>();
        bean.setCode("0000");
        bean.setMsg("success");
        if (save!=null) {
            HashMap<String, Product> map = new HashMap<>();
            map.put("product",product);
            bean.setResult(map);
        }
        return bean;
    }

    @ApiOperation(value = "获取所有产品列表")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResultBean<String,List<Product>> getAllProdList(){
        List<Product> list = repository.findAll();
        ResultBean<String, List<Product>> resultBean = new ResultBean<>();
        resultBean.setCode("0000");
        resultBean.setMsg("success");
        HashMap<String, List<Product>> map = new HashMap<>();
        map.put("productList",list);
        resultBean.setResult(map);
        return resultBean;
    }
}
