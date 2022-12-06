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
@Table(name = "mause")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","ComputerPartsMouse"})

public class Mouse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="mause_id")
	private int mauseId;
	
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
	
	@Column(name="purpose_of_usage ")
	private String purposeOfUsage ;
	
	@Column(name="DPI")
	private String DPI;
	
	@Column(name="color")
	private String color;
	
	@Column(name="mouse_type")
	private String mouseType;
	
	@Column(name="lighting")
	private String lighting;
	
	@ManyToOne()
	@JoinColumn(name = "computer_parts_id")
	private ComputerParts ComputerPartsMouse;
	


}
