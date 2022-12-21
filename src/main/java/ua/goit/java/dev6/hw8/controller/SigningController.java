package ua.goit.java.dev6.hw8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signing")
public class SigningController {
    @GetMapping
    public String getSigning(){
        return "signing/signing";
    }

}
