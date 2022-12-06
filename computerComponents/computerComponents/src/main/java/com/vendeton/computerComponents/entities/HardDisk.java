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
@Table(name = "hard_disk")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","ComputerPartsHardDisk"})

public class HardDisk {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="hard_disk_id")
	private int hardDiskId;
	
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
	
	@Column(name="connection_type ")
	private String connectionType ;
	
	@Column(name="disk_type")
	private String diskType;
	
	@Column(name="rotation_speed")
	private String rotationSpeed;
	
	@Column(name="cache_memory")
	private String cacheMemory;
	
	@ManyToOne()
	@JoinColumn(name = "computer_parts_id")
	private ComputerParts ComputerPartsHardDisk;
	


}
