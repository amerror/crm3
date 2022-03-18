package com.company.crm.workbench.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zytwl
 */
@Controller
@RequestMapping("workbench")
public class WorkbenchIndexContoller {

    @GetMapping("index.do")
    public String toIndex(){
        return "workbench/index";
    }

    @GetMapping("main/index.do")
    public String toMain(){return "workbench/main/index";}

}
