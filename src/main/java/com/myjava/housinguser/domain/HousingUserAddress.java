package com.myjava.housinguser.domain;

import java.time.OffsetDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class HousingUserAddress {
	@Id
	@GeneratedValue(generator="UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(length = 16, columnDefinition = "BINARY(16)", updatable = false, nullable = false)
	private UUID id;
	
	private String FirstName;
	
	private String LastName;
	
	private String eMail;
	
	private String PhoneNumber;
	
	private OffsetDateTime createdDate;
	

}
