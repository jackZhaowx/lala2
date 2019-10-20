package com.grp.controller;

/**
 * Created by Administrator on 2019/10/20 0020.
 */
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("/api/hello")
    public String hello() {
        return "hello";
    }


    @RequestMapping("/api/notneedlogin/hello")
    public String hello2() {
        return "hello2";
    }


    @PreAuthorize("hasAuthority('ROLE_USER')")
    @RequestMapping("/api/test1")
    public String test1() {
        return "test1";
    }


    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping("/api/test2")
    public String test2() {
        return "test2";
    }
}
