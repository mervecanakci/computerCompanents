package com.vendeton.computerComponents.entities.abstracts;

import java.util.List;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","ManagerUser","VerificationCodeUser","catagories_User"})

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="identity_number")	
	private String identityNumber;
	
	@Column(name="birth_year")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date  birthYear;
		
	@Column(name="email")
	@Email
	@NotBlank
	@NotNull
	private String email;
	
	@Column(name="password")
	private String password;
	
	
	
	@ManyToOne()
	@JoinColumn(name = "manager_id")
	private Manager ManagerUser;
	
	@ManyToOne()
	@JoinColumn(name = "verification_code_id")
	private VerificationCode VerificationCodeUser;
	

	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	List<Catagories_User> catagories_User;
	
	

}
