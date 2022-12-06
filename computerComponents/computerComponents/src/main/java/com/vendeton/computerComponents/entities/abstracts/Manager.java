package com.vendeton.computerComponents.entities.abstracts;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "manager")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","managerseller","manageruser","catagories_Manager"})

public class Manager {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="manager_id")
	private int managerId;
	
	@Column(name="first_name")
	@NotEmpty(message = "First name field cannot be left blank..")
	private String firstName;
	
	@Column(name="last_name")
	@NotEmpty(message = "Last name field cannot be left blank..")
	private String lastName;
	
	@Column(name="email",unique = true)
    @NotEmpty(message = "Email field cannot be left blank..")
    @Email
    private String email;
	
	@Column(name="password")
	@NotEmpty(message = "Password field cannot be left blank..")
	private String password;
	
	@JsonIgnore
	@OneToMany(mappedBy = "ManagerSeller")
	private List<Seller> managerseller;
	
	@JsonIgnore
	@OneToMany(mappedBy = "ManagerUser")
	private List<User> manageruser;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "manager")
	List<Catagories_Manager> catagories_Manager;
	
	
}
