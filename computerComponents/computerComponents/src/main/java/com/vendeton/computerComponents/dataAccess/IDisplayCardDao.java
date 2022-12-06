package com.vendeton.computerComponents.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendeton.computerComponents.entities.DisplayCard;

public interface IDisplayCardDao extends JpaRepository<DisplayCard, Integer>{

	DisplayCard getByName(String name);

	DisplayCard getByPrice(String price);

	DisplayCard getByDisplayCardId(int displayCardId);

}
