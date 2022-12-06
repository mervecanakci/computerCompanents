package com.vendeton.computerComponents.entities.abstracts;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


	@Data
	@Entity
	@Table(name="verification_code")
	@AllArgsConstructor
	@NoArgsConstructor
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler","users","sellers"})

	public class VerificationCode {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="verification_code_id")
		private int verificationCodeId;
		
		@Column(name="code")
		private String code;

		@Column(name="is_verified")
		private boolean isVerified;

		@Column(name="verified_date")
		private Date verifiedDate ;
		
		@JsonIgnore
		@OneToMany(mappedBy = "VerificationCodeUser")
		private List<User> users;
		
		@JsonIgnore
		@OneToMany(mappedBy = "VerificationCodeSeller")
		private List<Seller> sellers;


}
