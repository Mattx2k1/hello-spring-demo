package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    // handles request at path /hello
    // some annotations can accept some parameters and parenthesis
    @GetMapping("hello") // the path we want the handler to live at
    @ResponseBody
    public String hello() {
        return "Hello, Spring!";
    }

}
