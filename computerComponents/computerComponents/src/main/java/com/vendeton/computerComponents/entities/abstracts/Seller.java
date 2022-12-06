package com.vendeton.computerComponents.entities.abstracts;

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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "seller")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","ManagerSeller","VerificationCodeSeller","catagories_Seller"})

public class Seller {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="seller_id")
	private int sellerId;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="web_address")
	private String webAddress;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	
	@ManyToOne()
	@JoinColumn(name = "manager_id")
	private Manager ManagerSeller;
	
	@ManyToOne()
	@JoinColumn(name = "verification_code_id")
	private VerificationCode VerificationCodeSeller;
	
	
	
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "seller")
	List<Catagories_Seller> catagories_Seller;
	
	

	
}



		