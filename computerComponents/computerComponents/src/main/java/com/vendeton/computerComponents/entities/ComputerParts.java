package com.vendeton.computerComponents.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vendeton.computerComponents.entities.abstracts.Catagories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "computer_parts")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","ram","speaker","processor","powerSupply","mouse","microphone","mainboard","keyboard",
	"headset","hardDisk","displayCard","casing","CatagoriesComputerParts"})

public class ComputerParts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="computer_parts_id")
	private int computerPartsId;
	
	
	 @OneToMany(mappedBy="ComputerPartsRam")
	    private List<Ram> ram;
	
	 @OneToMany(mappedBy="ComputerPartsSpeaker")
	    private List<Speaker> speaker;	 
	 
	 @OneToMany(mappedBy="ComputerPartsProcessor")
	    private List<Processor> processor;
	 
	 @OneToMany(mappedBy="ComputerPartsPowerSupply")
	    private List<PowerSupply> powerSupply;
	 
	 @OneToMany(mappedBy="ComputerPartsMouse")
	    private List<Mouse> mouse;
	 
	 @OneToMany(mappedBy="ComputerPartsMicrophone")
	    private List<Microphone> microphone;
	 
	 @OneToMany(mappedBy="ComputerPartsMainboard")
	    private List<Mainboard> mainboard;
	 
	 @OneToMany(mappedBy="ComputerPartsKeyboard")
	    private List<Keyboard> keyboard;
	 
	 @OneToMany(mappedBy="ComputerPartsHeadset")
	    private List<Headset> headset;
	 
	 @OneToMany(mappedBy="ComputerPartsHardDisk")
	    private List<HardDisk> hardDisk;
	 
	 @OneToMany(mappedBy="ComputerPartsDisplayCard")
	    private List<DisplayCard> displayCard;
	 
	 @OneToMany(mappedBy="ComputerPartsCasing")
	    private List<Casing> casing;
	 
	
	 
	 @ManyToOne()
		@JoinColumn(name = "catagories_id")
		private Catagories CatagoriesComputerParts;
	 


}
