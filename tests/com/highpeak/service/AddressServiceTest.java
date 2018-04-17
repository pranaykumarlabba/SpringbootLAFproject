package com.highpeak.service;

import com.highpeak.springproject.*;
import com.highpeak.user.repository.AddressRepository;
import com.highpeak.user.repository.UserRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class AddressServiceTest {

    @Mock
    AddressRepository addressRepository;

    @Mock
    UserRepository userRepository;

    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();


    @InjectMocks
    AddressService addressService = new AddressService();


    @Test
    public void testAddAddress() {

    AddressModel addressModel = new AddressModel();

    Address address= new Address();

        Role role = new Role();

        User user = new User();

        role.setRole_id(1);
        role.setRoleName("Admin");

        user.setUserid(1);
        user.setName("pranay");
        user.setEmail("pranay@gmail.com");
        user.setPassword("pranay467");
        user.setAge(24);
        user.setPhone(91564983);
        user.setRole(role);

        addressModel.setAddress_id(1);
        addressModel.setdNo("c-170");
        addressModel.setStreet("Mvp colony");
        addressModel.setState("Andhra pradesh");
        addressModel.setCountry("India");
        addressModel.setUserid(1);


        address.setAddress_id(1);
        address.setdNo("c-170");
        address.setStreet("A-colony");
        address.setState("Andhra pradesh");
        address.setCountry("India");
        address.setUser(user);


    when(addressRepository.save(any(Address.class))).thenReturn(address);
    when(userRepository.save(any(User.class))).thenReturn(user);
    when(userRepository.findUserByUserid(anyInt())).thenReturn(user);
    Address addressess=addressService.addAddress(addressModel);
    assertEquals(addressModel.getdNo(),address.getdNo());

        }
}