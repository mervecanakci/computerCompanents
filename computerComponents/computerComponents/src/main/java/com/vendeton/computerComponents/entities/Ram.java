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
@Table(name = "ram")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","ComputerPartsRam"})

public class Ram {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ram_id")
	private int ramId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="property ")
	private String property ;
	
	@Column(name="price")
	private String price;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="capacity")
	private String capacity;
	
	@Column(name="speed")
	private String speed;
	
	@Column(name="compatible_systems")
	private String compatibleSystems;
	
	@Column(name="usage_type")
	private String usageType;
	

	
	@ManyToOne()
	@JoinColumn(name = "computer_parts_id")
	private ComputerParts ComputerPartsRam;
	
	

}
