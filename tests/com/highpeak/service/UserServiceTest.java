package com.highpeak.service;


import com.highpeak.springproject.Role;
import com.highpeak.springproject.User;
import com.highpeak.springproject.UserModel;
import com.highpeak.user.repository.UserRepository;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();


    @InjectMocks
    UserService userService = new UserService();

    @Test
    public void testUserRegistration(){

        UserModel userModel = new UserModel();

        User user = new User();

        Role role = new Role();

        role.setRole_id(2);
        role.setRoleName("Admin");


        userModel.setUserid(5);
        userModel.setName("phani");
        userModel.setEmail("phani@gmail.com");
        userModel.setPassword("P@467");
        userModel.setAge(24);
        userModel.setPhoneNum(888954215);
        userModel.setRole(role);

        user.setUserid(5);
        user.setName("phani");
        user.setEmail("phani@gmail.com");
        user.setPassword("P@467");
        user.setAge(24);
        user.setPhone(888954215);
        user.setRole(role);


        when(userRepository.save(any(User.class))).thenReturn(user);
       User userOne= userService.userRegistration(userModel);
        assertEquals(userModel.getName(),user.getName());

        }

        @Test
        public void testfindByEmailAndPassword(){

        User user = new User();
        user.setUserid(1);
        user.setName("Visakha");
        user.setEmail("v@gmail.com");
        user.setPassword("zxcvbnm");
        user.setAge(28);
        user.setPhone(887546212);

        when(userRepository.findByEmailAndPassword(anyString(),anyString())).thenReturn(user);
        User userOne = userService.findByEmailAndPassword("v@gmail.com","zxcvbnm");
        assertEquals(user,userOne);
        }

        @Test
        public void testFindByEmail(){

        doNothing().when(userRepository).findByEmail(anyString(),anyString());
         String res =  userService.findByEmail("v@gmail.com","asdfghjkl");
        assertEquals("Updated.....",res);

        }

        @Test
        public  void testGetId(){
            User user = new User();
            user.setUserid(5);
       when(userRepository.findUserByUserid(anyInt())).thenReturn(user);
        User userOne = userService.getId(5);
        assertEquals(user,userOne);

        }

       }


