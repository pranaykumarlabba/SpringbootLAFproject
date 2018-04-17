package com.highpeak.user.repository;

import com.highpeak.springproject.Address;
import com.highpeak.springproject.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {


}
