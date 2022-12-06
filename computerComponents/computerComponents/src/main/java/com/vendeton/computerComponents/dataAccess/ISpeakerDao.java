package com.vendeton.computerComponents.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendeton.computerComponents.entities.Speaker;

public interface ISpeakerDao extends JpaRepository<Speaker, Integer> {

	Speaker getByName(String name);

	Speaker getByPrice(String price);

	Speaker getBySpeakerId(int speakerId);

	

	

}
