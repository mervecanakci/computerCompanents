package com.vendeton.computerComponents.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendeton.computerComponents.entities.abstracts.Catagories_Manager;

public interface ICatagories_ManagerDao extends JpaRepository<Catagories_Manager, Integer>{

}
