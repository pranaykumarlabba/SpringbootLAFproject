package com.highpeak.service;

import com.highpeak.springproject.Address;
import com.highpeak.springproject.AddressModel;
import com.highpeak.springproject.User;
import com.highpeak.springproject.UserModel;
import com.highpeak.user.repository.AddressRepository;
import com.highpeak.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;




    public User userRegistration(UserModel userModel) {

        User user = new User();
        user.setUserid(userModel.getUserid());
        user.setName(userModel.getName());
        user.setEmail(userModel.getEmail());
        user.setPassword(userModel.getPassword());
        user.setAge(userModel.getAge());
        user.setPhone(userModel.getPhoneNum());
        user.setRole(userModel.getRole());
        User user1 = userRepository.save(user);

        return user1;

    }
    public User findByEmailAndPassword(String email, String password) {

        //if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    @Transactional
    public String findByEmail(String email, String newPassword) {

        userRepository.findByEmail(email, newPassword);

        return "Updated.....";

    }

    public List<User> getAllUser() {

        List<User> userData = new ArrayList<>();
        List<User> userList = userRepository.findAlluser();
        for (User userList1 : userList) {
            if (!userList1.getEmail().equals("nch@gmail.com")) {

                userData.add(userList1);
            }
        }
        return userData;
        }

        public User getId(int userId){

        return userRepository.findUserByUserid(userId);
        }


}










