package com.myjava.housinguser.domain;

import java.time.OffsetDateTime;
import java.util.UUID;

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
	
	private String userName;
	
	private String userPwd; 
	private	String customerLevel;
	
	
	@OneToOne(targetEntity = HousingUserAddress.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "id")
	private HousingUserAddress userAddress;
	
	private OffsetDateTime createdDate;
	
	private OffsetDateTime lastLoginDate;

}
