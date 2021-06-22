package com.example.docker.demo.controller;

import com.example.docker.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.util.Random;

@RestController
public class DockerDemoController {

    private Random r = new Random();

    @Value("${app.config-path}")
    private String configPath;

    @Autowired
    private DemoService service;

    @ResponseBody
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello! How are you?";
    }

    @ResponseBody
    @GetMapping("/greet")
    public String greet() {
        return String.format("Hello %s, Config path: %s",
                service.getName(new Long(r.nextInt(10) +  1)), configPath);
    }

    @ResponseBody
    @GetMapping("/server")
    public String getServer() throws Exception {
        return String.format("I am a POD: %s\n", InetAddress.getLocalHost().getHostName());
    }
}
