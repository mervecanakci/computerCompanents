package com.vendeton.computerComponents.dataAccess;


import org.springframework.data.jpa.repository.JpaRepository;


import com.vendeton.computerComponents.entities.ThermalPaste;

public interface IThermalPasteDao extends JpaRepository<ThermalPaste, Integer> {

	ThermalPaste getByName(String name);

	ThermalPaste getByPrice(String price);

	ThermalPaste getByThermalPasteId(int thermalPasteId);

}
