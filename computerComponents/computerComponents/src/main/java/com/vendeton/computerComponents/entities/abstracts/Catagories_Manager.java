package com.vendeton.computerComponents.entities.abstracts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "catagories_manager")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","manager","catagories"})

public class Catagories_Manager {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="catagories_manager_id")
	private int catagories_managerId;
	
	
	   @JsonIgnore
	    @ManyToOne
	    @JoinColumn(name = "manager_id")
	     private Manager manager;
		
	    @JsonIgnore
	    @ManyToOne
	    @JoinColumn(name = "catagories_id")
	     private Catagories catagories;
		
	

}
