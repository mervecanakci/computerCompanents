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
@Table(name = "display_card")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","ComputerPartsDisplayCard"})

public class DisplayCard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="display_card_id")
	private int displayCardId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="property ")
	private String property ;
	
	@Column(name="price")
	private String price;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="graphics_processor")
	private String graphicsProcessor;
	
	@Column(name="graphics_memory ")
	private String graphicsMemory ;
	
	@Column(name="chip_set")
	private String chipSet;
	
	@Column(name="bit_value")
	private String bitValue;
	
	@Column(name="memory_type")
	private String memoryType;
	
	@Column(name="slot_type ")
	private String slotType ;
	
	@Column(name="video_card_memory")
	private String videoCardMemory;
	
	
	
	@ManyToOne()
	@JoinColumn(name = "computer_parts_id")
	private ComputerParts ComputerPartsDisplayCard;
	
}
