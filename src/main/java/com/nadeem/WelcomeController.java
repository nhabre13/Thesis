package com.nadeem;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class WelcomeController {

//    //inject via application.properties
//    @Value("${consent.message:test}")
//    private String message = "Hello World";
//
//
//    @RequestMapping("/")
//    public String welcome(Map<String, Object> model) {
//        model.put("message", this.message);
//        return "welcome";
//    }

    @RequestMapping(value = "/put", method = RequestMethod.POST)
    public @ResponseBody UserData put(@RequestBody final UserData userData) {
        return userData;
    }

}
