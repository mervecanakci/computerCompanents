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
@Table(name = "casing")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","ComputerPartsCasing"})

public class Casing {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="casing_id")
	private int casingId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="property ")
	private String property ;
	
	@Column(name="price")
	private String price;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="power_supply")
	private String powerSupply;
	
	@Column(name="mainboard_support")
	private String mainboardSupport;
	
	@Column(name="dimensions ")
	private String dimensions ;
	
	@Column(name="total_fans")
	private String totalFans;
	
	@Column(name="liquid_cooling_support")
	private String liquidCoolingSupport;
	
	@Column(name="color")
	private String color;
	
	@Column(name="case_lighting ")
	private String caseLighting ;
	
	@Column(name="internal_fans")
	private String internalFans;
	
	@Column(name="maximum_VGA_length")
	private String MaximumVGALength;
	
	
	@ManyToOne()
	@JoinColumn(name = "computer_parts_id")
	private ComputerParts ComputerPartsCasing;
	
	


	
}
