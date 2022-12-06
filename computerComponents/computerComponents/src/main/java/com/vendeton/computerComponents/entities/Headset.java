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
@Table(name = "headset")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","ComputerPartsHeadset"})

public class Headset {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="headset_id")
	private int headsetId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="property ")
	private String property ;
	
	@Column(name="price")
	private String price;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="cable_length")
	private String cableLength;
	
	@Column(name="usage_type ")
	private String usageType ;
	
	@Column(name="color")
	private String color;
	
	@ManyToOne()
	@JoinColumn(name = "computer_parts_id")
	private ComputerParts ComputerPartsHeadset;
	
	

}
