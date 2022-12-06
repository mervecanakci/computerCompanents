package com.vendeton.computerComponents.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "speaker")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","ComputerPartsSpeaker"})

public class Speaker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="speaker_id")
	private int speakerId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="property ")
	private String property ;
	
	@Column(name="price")
	private String price;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="number_of_speakers")
	private String numberOfSpeakers;
	
	@Column(name="bluetooth ")
	private String bluetooth ;
	
	@Column(name="electric_inlet")
	private String electricInlet;
	
	@Column(name="remote_control")
	private String remoteControl;
	
	@Column(name="color")
	private String color;
	
	
	@ManyToOne()
	@JoinColumn(name = "computer_parts_id")
	private ComputerParts ComputerPartsSpeaker;
	
	
	
}