package com.vendeton.computerComponents.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.vendeton.computerComponents.entities.abstracts.Manager;

public interface IManagerDao extends JpaRepository<Manager, Integer> {

	Manager getByManagerId(int managerId);
	Manager getByFirstName(String firstName);
	Manager getByLastName(String lastName);
	Manager getByEmail(String email);
	Manager getByPassword(String password);

	
	@Transactional
    @Modifying
    @Query("DELETE From Manager m where m.managerId=:managerId")
    void deleteByManagerId(int managerId);
 
	@Transactional
    @Modifying
    @Query("UPDATE Manager m SET m.firstName=:firstNameUpdate WHERE m.managerId=:managerId")
    void updateByFirstName(int managerId,String firstNameUpdate);
	
	@Transactional
    @Modifying
    @Query("UPDATE Manager m SET m.lastName=:lastNameUpdate WHERE m.managerId=:managerId")
    void updateByLastName(int managerId,String lastNameUpdate);
	
	@Transactional
    @Modifying
    @Query("UPDATE Manager m SET m.email=:emailUpdate WHERE m.managerId=:managerId")
    void updateByEmail(int managerId,String emailUpdate);
	
	@Transactional
    @Modifying
    @Query("UPDATE Manager m SET m.password=:passwordUpdate WHERE m.managerId=:managerId")
    void updateByPassword(int managerId,String passwordUpdate);
	
	
	
	
	
	
	
	
	
	
}
