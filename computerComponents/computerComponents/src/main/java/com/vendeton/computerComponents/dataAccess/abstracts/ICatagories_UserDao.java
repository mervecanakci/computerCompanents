package com.vendeton.computerComponents.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendeton.computerComponents.entities.abstracts.Catagories_User;

public interface ICatagories_UserDao extends JpaRepository<Catagories_User, Integer> {

}
