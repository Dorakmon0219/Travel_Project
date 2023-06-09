package com.qianfeng.controller;

import com.qianfeng.domain.Product;
import com.qianfeng.service.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Resource
    private IProductService productService;  //找到框架帮我们创建的对象

    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView mav = new ModelAndView();
        List<Product> productList = productService.findAll();
        mav.addObject("productList", productList);
        mav.setViewName("product-list");
        return mav;
    }

    @RequestMapping("/addProduct")
    public String addProduct(Product product) {
        productService.addProduct(product);
        return "redirect:/product/findAll";
    }

    @RequestMapping("/findById")
    public ModelAndView findById(String id) {
        ModelAndView mav = new ModelAndView();
        Product product = productService.findById(id);
        mav.addObject("product", product);
        mav.setViewName("product-update");
        return mav;
    }

    @RequestMapping("/update")
    public String updateProduct(Product product) {
        productService.updateProduct(product);
        return "redirect:/product/findAll";
    }

    @RequestMapping("/deleteByIds")
    public String deleteByIds(String[] ids) {
        productService.deleteByIds(ids);
        return "redirect:/product/findAll";
    }

}
