package com.kirito.dsy.crm.controller;

import com.kirito.dsy.crm.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Kirito on 16/5/30.
 */
@Controller
public class TestController {
    @Autowired
    ITestService testService;

    @RequestMapping("/test.do")
    @ResponseBody
    public ModelAndView test(Model model){


        int age = testService.insertName(2);
        model.addAttribute("age", age);
        return new ModelAndView("ok");
    }
}

