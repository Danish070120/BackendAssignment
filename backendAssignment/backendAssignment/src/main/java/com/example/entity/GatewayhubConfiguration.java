package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class GatewayhubConfiguration {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "accountid")
	private String accountid;

	@Column(name = "authToken")
	private String authToken;

	@Column(name = "trialnumber")
	private String trialNumber;

}
