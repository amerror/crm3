package com.company.crm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zytwl
 */
@Controller
@RequestMapping(value ={"/","index","login"})
public class IndexController {

    @GetMapping
    public String index(){
        return "index";
    }
}
