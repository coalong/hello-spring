package com.example.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "home";
    }


//    @GetMapping("hello")
//    public String hello(Model model) {
//        model.addAttribute("data", "hello!");
//        return "hello";
//    }
//
//    //required 기본값 true 이다. fasle로 설정하면 값 안 넘겨도 된다.
//    @GetMapping("hello-mvc")
//    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model) {
//        model.addAttribute("name", name);
//        return "hello-template";
//    }
//
//    @GetMapping("hello-string")
//    @ResponseBody
//    public String helloString(@RequestParam("name") String name) {
//        return "hello" + name;
//    }
//
//    @GetMapping("hello-api")
//    @ResponseBody
//    public Hello helloApi(@RequestParam("name") String name) {
//        Hello hello = new Hello();
//        hello.setName(name);
//        return hello;
//    }
//
//    static class Hello {
//        private String name;
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//    }
}
