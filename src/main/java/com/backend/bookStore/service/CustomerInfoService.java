package com.backend.bookStore.service;

import com.backend.bookStore.entity.CartEntity;
import com.backend.bookStore.entity.CustomerInfoEntity;
import com.backend.bookStore.entity.Login;
import com.backend.bookStore.model.CustomerInfoRequest;
import com.backend.bookStore.repository.CartRepository;
import com.backend.bookStore.repository.CustomerInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerInfoService {
    @Autowired
    CustomerInfoRepository customerInfoRepository;

    @Autowired
    CartRepository cartRepository;


    public CustomerInfoEntity createCustomerInfo(CustomerInfoRequest customerInfo) {
        System.out.println("customerPhoneNumber"+customerInfo.getUserName());
        System.out.println("customerPhoneNumber"+customerInfo.getPhoneNumber());
         CustomerInfoEntity customerPhoneNumber=customerInfoRepository.findByPhoneNumber(customerInfo.getPhoneNumber());
        CustomerInfoEntity customerInfoUserName = customerInfoRepository.findByName(customerInfo.getUserName());
        System.out.println("customerPhoneNumber"+customerPhoneNumber);
        System.out.println("customerPhoneNumber"+customerInfoUserName);
      if(customerInfoUserName != null || customerPhoneNumber !=null ){
          throw new ArithmeticException("User is already registered");
      }
      else {
          System.out.println("customerInfo"+customerInfo.getFirstName()+customerInfo.getLastName()
                  +customerInfo.getConfirmpassword()+customerInfo.getPhoneNumber()
                  +customerInfo.getUserName()+customerInfo.getPassword()+customerInfo.getEmail());
          CustomerInfoEntity customerInfoEntity =customerInfo.toEntity(customerInfo);
          System.out.println("customerInfo"+customerInfoEntity.getFirstName()+customerInfoEntity.getLastName()
                  +customerInfoEntity.getConfirmPassword()+customerInfoEntity.getPhoneNumber()
                  +customerInfoEntity.getUserName()+customerInfoEntity.getPassword()
                  +customerInfoEntity.getEmail());
          return customerInfoRepository.save(customerInfoEntity);
      }
    }

    public CustomerInfoEntity loginUser(Login login) {
        CustomerInfoEntity customerInfoUserName = customerInfoRepository.findByName(login.getUserName());
        if (customerInfoUserName != null) {
            if (customerInfoUserName.getPassword().equals(login.getPassword())) {
                return customerInfoRepository.findUserAndPassword(login.getUserName(), login.getPassword());
            } else {
                throw new ArithmeticException("Password is InCorrect");
            }
        } else {
            throw new ArithmeticException("Password is InCorrect");
        }
    }

    public List<CartEntity> getCustomerInfo(String phoneNumber) {
        List<CartEntity> getCustomer = cartRepository.findByname(phoneNumber);
        if (getCustomer != null) {
           return getCustomer;
        } else {
            throw new ArithmeticException("Password is InCorrect");
        }
    }
}
