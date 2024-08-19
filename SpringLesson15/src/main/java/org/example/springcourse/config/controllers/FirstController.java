package org.example.springcourse.config.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/calculator")
    public String calculator(@RequestParam("a") int a,
                           @RequestParam("b") int b,
                           @RequestParam("acton") String action,
                           Model model){

        double result;

        switch(action){

            case "add":
                result = a+b;
                break;
            case "minus":
                result=a-b;
                break;
            case "multily":
                result = a*b;
                break;
            case "divide":
                result=a/(double)b;
                break;
            default:
                result =0;
                break;
        }
        model.addAttribute("message",result);

        return "first/calculator";


    }


    }






