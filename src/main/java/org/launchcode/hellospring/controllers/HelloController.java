package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody // can add at top of class if each method uses this annotation
@RequestMapping("hello") // this says every method within this class should begin with '/hello'
public class HelloController {

    // handles request at path /hello
    // some annotations can accept some parameters and parenthesis
    // When two handlers live at the same address?:
    // Caused by: java.lang.IllegalStateException: Ambiguous mapping. Cannot map 'helloController' method

//    @GetMapping("hello") // the path we want the handler to live at
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    // after changes (line 8) this lives at '/hello/goodbye'
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Springy!";
    }

    // after changes (line 8) this lives at '/hello/hello'
    // Handler that handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";

    }

    // after changes (line 8) this lives at '/hello/hello/{name}'??
    // Handler handles requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!!";

    }

    // after changes (line 8) this lives at '/hello/formgit'
    @GetMapping("form")
    @ResponseBody
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + // tells it to submit a request to /hello
                "<input type='text' name='name'>" +
                "<input type ='submit' value='Greet Me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }


}
