package ru.javacourse.spring.rest;

import ru.javacourse.spring.entity.User;
import ru.javacourse.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Author: Georgy Gobozov
 * Date: 21.12.15
 */
@RestController
public class UserRestController {


    @Autowired
    UserService userService;


    @PostConstruct
    public void init(){
        System.out.println("Start controller.");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<User> getAllUsers(ModelMap model) {
        return userService.getAll();
    }


    @RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
    public User getUser(@PathVariable("id") String userId){
        return userService.getById(Long.parseLong(userId));
    }


    @RequestMapping(method = RequestMethod.POST, value = "/users/create", headers = {"accept=application/json"})
    public String createUser(@RequestBody User user){
        userService.create(user);
        return "ok";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
    public String deleteUser(@PathVariable("id") String userId){
        User user = userService.getById(Long.parseLong(userId));
        userService.delete(user);
        return "ok";
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
    public String updateUser(@PathVariable("id") String userId, @RequestBody User user){
        user.setUserId(Long.parseLong(userId));
        userService.update(user);
        return "ok";
    }


}
