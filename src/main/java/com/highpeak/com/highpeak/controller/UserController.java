package com.highpeak.com.highpeak.controller;

import com.highpeak.service.UserService;
import com.highpeak.springproject.Address;
import com.highpeak.springproject.AddressModel;
import com.highpeak.springproject.User;
import com.highpeak.springproject.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@EnableAutoConfiguration
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userRegistration",method = RequestMethod.POST)
    public User userRegistration(@RequestBody UserModel userModel){

        return userService.userRegistration(userModel);
    }

    @RequestMapping(path = "/{email}/{password}",method = RequestMethod.GET)
    public  User findByEmailAndPassword(@PathVariable("email") String email,
                                        @PathVariable("password") String password){

        return userService.findByEmailAndPassword(email, password);
    }
    @RequestMapping(path = "/{email}/{newPassword}",method = RequestMethod.POST)
    public String findByEmail(@PathVariable("email") String email,
                              @PathVariable("newPassword")String newPassword){
        return userService.findByEmail(email,newPassword);
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }

    @RequestMapping(value = "/{userId}",method = RequestMethod.GET)
    public User getId(@PathVariable("userId") int userId){
        return userService.getId(userId);
    }


}
