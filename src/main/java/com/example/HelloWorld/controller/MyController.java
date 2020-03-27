package com.example.HelloWorld.controller;
import com.example.HelloWorld.MyService;
import com.example.HelloWorld.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private MyService service;

    @RequestMapping("/hello")
    public String MyMethod() {
        return service.myMethod();
    }

    @RequestMapping("/user/newusers/{name}")
    private User saveUser(@PathVariable("name") String name ){
        User persona = new User();
        persona.setName(name);
        return service.saveUser(persona);
    }

    @RequestMapping("/user/newusers")
    private String saveLogin(){
        return "ONLY USERS AUTHENTICATED";
    }

    @RequestMapping("/user/dba")
    private String onlyDba(){
        return "ONLY dba";
    }

    @RequestMapping("/user/freeaccess")
    private String free(){
        return "free user";
    }
}
