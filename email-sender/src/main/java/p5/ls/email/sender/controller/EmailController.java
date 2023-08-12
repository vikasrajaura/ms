package p5.ls.email.sender.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmailController {

    @GetMapping("/")
    public String test(){
        return "home";
    }
}
