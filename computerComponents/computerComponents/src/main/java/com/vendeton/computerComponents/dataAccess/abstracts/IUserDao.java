package com.vendeton.computerComponents.dataAccess.abstracts;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.vendeton.computerComponents.entities.abstracts.User;

public interface IUserDao extends JpaRepository<User, Integer>{
	User getByUserId(int userId);
	User getByFirstName(String firstName);
	User getByLastName(String lastName);
	User getByIdentityNumber(String identityNumber);
	User getByBirthYear(Date birthYear);
	User getByEmail(String email);
	User getByPassword(String password);

	
	@Transactional
    @Modifying
    @Query("DELETE From User u where u.userId=:userId")
    void deleteByUserId(int userId);
 
	@Transactional
    @Modifying
    @Query("UPDATE User u SET u.firstName=:firstNameUpdate WHERE u.userId=:userId")
    void updateByFirstName(int userId,String firstNameUpdate);
	
	@Transactional
    @Modifying
    @Query("UPDATE User u SET u.lastName=:lastNameUpdate WHERE u.userId=:userId")
    void updateByLastName(int userId,String lastNameUpdate);
	
	@Transactional
    @Modifying
    @Query("UPDATE User u SET u.email=:emailUpdate WHERE u.userId=:userId")
    void updateByEmail(int userId,String emailUpdate);
	
	@Transactional
    @Modifying
    @Query("UPDATE User u SET u.password=:passwordUpdate WHERE u.userId=:userId")
    void updateByPassword(int userId,String passwordUpdate);
	
	
	
	
	
	
	
	
	
	

}
