package com.highpeak.com.highpeak.controller;

import com.highpeak.service.AddressService;
import com.highpeak.springproject.Address;
import com.highpeak.springproject.AddressModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
@RequestMapping(value = "/address")
public class AddressController {

    @Autowired
    public AddressService addressService;

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Address addUserAddress(@RequestBody AddressModel addressModel){
        return addressService.addAddress(addressModel);
    }

}
