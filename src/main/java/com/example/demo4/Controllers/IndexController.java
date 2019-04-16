package com.example.demo4.Controllers;

import com.example.demo4.Models.LoginModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

        @RequestMapping("/")
        public String index(Model model) {

            model.addAttribute("username",LoginModel.username);

            return "index";

        }
    }
