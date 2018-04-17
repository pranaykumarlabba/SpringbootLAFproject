package com.highpeak.service;

import com.highpeak.springproject.Address;
import com.highpeak.springproject.AddressModel;
import com.highpeak.user.repository.AddressRepository;
import com.highpeak.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;

    public Address addAddress(AddressModel addressModel){

        Address address = new Address();
        address.setdNo(addressModel.getdNo());
        address.setStreet(addressModel.getStreet());
        address.setState(addressModel.getState());
        address.setCountry(addressModel.getCountry());
        address.setUser(userRepository.findUserByUserid(addressModel.getUserid()));

        return addressRepository.save(address);
    }

}
