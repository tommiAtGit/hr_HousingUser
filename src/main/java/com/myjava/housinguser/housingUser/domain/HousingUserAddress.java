package com.myjava.housinguser.housingUser.domain;

import java.time.OffsetDateTime;
import java.util.UUID;

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
public class HousingUserAddress {
	
	private UUID id;
	
	private String FirstName;
	
	private String LastName;
	
	private String eMail;
	
	private String PhoneNumber;
	
	private OffsetDateTime createdDate;
	

}
