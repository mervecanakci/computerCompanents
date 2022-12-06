package com.vendeton.computerComponents.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendeton.computerComponents.entities.Microphone;

public interface IMicrophoneDao  extends JpaRepository<Microphone, Integer>{

	Microphone getByName(String name);

	Microphone getByPrice(String price);

	Microphone getByMicrophoneId(int microphoneId);

}
