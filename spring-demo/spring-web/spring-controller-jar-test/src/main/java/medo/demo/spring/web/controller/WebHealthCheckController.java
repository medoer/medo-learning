package medo.demo.spring.web.controller;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebHealthCheckController {

    @GetMapping("demo/web/health")
    public String health() {
        return "hello web!";
    }

}
