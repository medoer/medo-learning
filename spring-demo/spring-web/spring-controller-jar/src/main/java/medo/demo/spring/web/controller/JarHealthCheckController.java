package medo.demo.spring.web.controller;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JarHealthCheckController {

    @GetMapping("demo/web/jar/health")
    public String health() {
        return "hello JAR!";
    }

}
