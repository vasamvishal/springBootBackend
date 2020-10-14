package com.backend.bookStore.repository;

import com.backend.bookStore.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CartRepository extends JpaRepository<CartEntity,Integer> {
    @Transactional
    @Modifying
    @Query("delete from CartEntity b where b.phoneNumber=:phoneNumber and b._id=:_id")
    void delete(@Param("phoneNumber") String phoneNumber,@Param("_id") String _id);

    @Query("select b from CartEntity b where b.phoneNumber=:phoneNumber")
    List<CartEntity> findByname(@Param("phoneNumber")String phoneNumber);

    @Query("select b from CartEntity b where b._id=:_id")
    List<CartEntity> findByID(@Param("_id") String _id);

}
