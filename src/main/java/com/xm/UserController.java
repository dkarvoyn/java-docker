package com.xm;

import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
public class UserController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private UserManager manager = UserManager.getInstance();

    @RequestMapping(value = "/user/{login}", method =  RequestMethod.GET)
    public UsersEntity getUser(@PathVariable("login") int login) {
        UsersEntity user = manager.getUser(login);
        log.info("Found user: " + user);
        return user;
    }
}
