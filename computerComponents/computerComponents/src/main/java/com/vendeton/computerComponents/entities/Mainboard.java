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
@Table(name = "mainboard")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","ComputerPartsMainboard"})

public class Mainboard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="mainboard_id")
	private int mainboardId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="property ")
	private String property ;
	
	@Column(name="price")
	private String price;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="processorSocketType")
	private String processorSocketType;
	
	@Column(name="chipset ")
	private String chipset ;
	
	@Column(name="wifi")
	private String wifi;
	
	@Column(name="RAM_capacity")
	private String RAMCapacity;
	
	@Column(name="HDMI_output")
	private String HDMIOutput;
	
	@Column(name="internal_video_card ")
	private String internalVideoCard ;
	
	@Column(name="PCI_slot")
	private String PCISlot;
	
	
	@ManyToOne()
	@JoinColumn(name = "computer_parts_id")
	private ComputerParts ComputerPartsMainboard;
	
	

}
