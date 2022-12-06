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
@Table(name = "keyboard")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","ComputerPartsKeyboard"})

public class Keyboard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="keyboard_id")
	private int keyboardId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="property ")
	private String property ;
	
	@Column(name="price")
	private String price;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="connection")
	private String connection;
	
	@Column(name="keyboard_type ")
	private String keyboardType ;
	
	@Column(name="language")
	private String language;
	
	@Column(name="purpose_of_usage")
	private String purposeOfUsage;
	
	@Column(name="lighting")
	private String lighting;
	
	@Column(name="color ")
	private String color ;
	
	@Column(name="touchpad")
	private String touchpad;
	
	@ManyToOne()
	@JoinColumn(name = "computer_parts_id")
	private ComputerParts ComputerPartsKeyboard;
	
	

}
