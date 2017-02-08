package ru.homecredit.springstart.controller;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

/**
 * @author dima
 */
@RestController
@Scope(value = SCOPE_PROTOTYPE)
public class HelloWorldPrototypeController implements InitializingBean {

    @GetMapping(value = "/hello1")
    public String hello() {
        return "Hello world";
    }

    @GetMapping(value = "1/helloMan")
    public String helloMen(@RequestParam String name) {
        return "Hello " + name;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(" ********* HelloWorldPrototypeController.afterPropertiesSet");
    }

    @PostConstruct
    public void init() throws Exception {
        System.out.println(" ********* HelloWorldPrototypeController PostConstruct");
    }
}
