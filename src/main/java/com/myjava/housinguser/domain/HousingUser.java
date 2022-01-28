package com.myjava.housinguser.domain;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class HousingUser {

	@Id
	@GeneratedValue(generator="UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(length = 16, columnDefinition = "BINARY(16)", updatable = false, nullable = false)
	private UUID id;
	@Column(name = "username")
	private String userName;
	@Column(name = "password")
	private String userPwd;
	//@Column(name = "CustomerLevel")
	//private	String  customerLevel;
	//@Column(name = "UserAddress")
	@OneToOne(targetEntity = HousingUserAddress.class, fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(nullable = false, name = "id")
	private HousingUserAddress userAddress;
//	@Column(name = "CreateDate")
//	private LocalDateTime createdDate;
//	@Column(name = "LastLoginDate")
//	private LocalDateTime lastLoginDate;

}
