package com.vendeton.computerComponents.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.vendeton.computerComponents.entities.abstracts.Seller;

public interface ISellerDao extends JpaRepository<Seller, Integer> {
Seller getBySellerId(int sellerId);
Seller getByCompanyName(String companyName);
Seller getByWebAddress(String webAddress);
Seller getByPhoneNumber(String phoneNumber);
Seller getByEmail(String email);



@Transactional
@Modifying
@Query("DELETE From Seller s where s.sellerId=:sellerId")
void deleteBySellerId(int sellerId);

@Transactional
@Modifying
@Query("UPDATE Seller s SET s.companyName=:companyNameUpdate WHERE s.sellerId=:sellerId")
void updateByCompanyName(int sellerId,String companyNameUpdate);

@Transactional
@Modifying
@Query("UPDATE Seller s SET s.webAddress=:webAddressUpdate WHERE s.sellerId=:sellerId")
void updateByWebAddress(int sellerId,String webAddress);

@Transactional
@Modifying
@Query("UPDATE Seller s SET s.phoneNumber=:phoneNumberUpdate WHERE s.sellerId=:sellerId")
void updateByPhoneNumber(int sellerId,String phoneNumberUpdate);

@Transactional
@Modifying
@Query("UPDATE Seller s SET s.email=:emailUpdate WHERE s.sellerId=:sellerId")
void updateByEmail(int sellerId, String emailUpdate);

@Transactional
@Modifying
@Query("UPDATE Seller s SET s.password=:passwordUpdate WHERE s.sellerId=:sellerId")
void updateByPassword(int sellerId, String passwordUpdate);
Seller getByPassword(String password);








}
