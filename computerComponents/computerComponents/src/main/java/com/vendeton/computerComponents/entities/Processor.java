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
@Table(name = "processor")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","ComputerPartsProcessor"})

public class Processor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="processor_id")
	private int processorId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="property ")
	private String property ;
	
	@Column(name="price")
	private String price;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="processor_technology")
	private String processorTechnology;
	
	@Column(name="processor_generation ")
	private String processorGeneration ;
	
	@Column(name="socket_structure")
	private String socketStructure;
	
	@Column(name="processor_number")
	private String processorNumber;
	
	
	@ManyToOne()
	@JoinColumn(name = "computer_parts_id")
	private ComputerParts ComputerPartsProcessor;
	
	
	
}
