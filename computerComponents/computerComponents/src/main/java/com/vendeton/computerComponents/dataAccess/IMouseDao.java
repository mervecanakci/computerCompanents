package com.vendeton.computerComponents.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendeton.computerComponents.entities.Mouse;

public interface IMouseDao extends JpaRepository<Mouse, Integer>{

	Mouse getByName(String name);

	Mouse getByPrice(String price);

	Mouse getByMauseId(int mauseId);

}
