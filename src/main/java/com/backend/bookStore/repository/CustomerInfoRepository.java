package com.backend.bookStore.repository;

import com.backend.bookStore.entity.CustomerInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CustomerInfoRepository extends JpaRepository<CustomerInfoEntity,Integer> {
//    @Transactional
//    @Modifying
//where c.firstName=:firstName and c.password=:password"
    @Query("select c from CustomerInfoEntity c where c.userName=:userName and c.password=:password")
    CustomerInfoEntity findUserAndPassword(@Param("userName") String userName,
                                                 @Param("password") String password);

    @Query("select c from CustomerInfoEntity c where  c.PhoneNumber=:phoneNumber or c.userName=:userName")
    CustomerInfoEntity findByPhoneNumberAndUserName(@Param("phoneNumber") String phoneNumber,@Param("userName") String userName);

    @Query("select c from CustomerInfoEntity c where c.userName=:userName")
    CustomerInfoEntity findByName(@Param("userName") String userName);


    @Query("select c from CustomerInfoEntity c where c.password=:password")
    CustomerInfoEntity findByPassword(@Param("password") String password);

    @Query("select c from CustomerInfoEntity c where c.PhoneNumber=:phoneNumber")
    CustomerInfoEntity findByPhoneNumber(@Param("phoneNumber") String phoneNumber);
}
