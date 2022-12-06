package com.vendeton.computerComponents.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendeton.computerComponents.entities.Keyboard;

public interface IKeyboardDao extends JpaRepository<Keyboard, Integer>{

	Keyboard getByName(String name);

	Keyboard getByPrice(String price);

	Keyboard getByKeyboardId(int keyboardId);

}
