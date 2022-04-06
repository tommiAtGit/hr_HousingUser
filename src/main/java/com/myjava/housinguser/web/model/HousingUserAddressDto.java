package com.myjava.housinguser.web.model;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HousingUserAddressDto {
	
	@Null
	private UUID id;
	@NotBlank
	private String FirstName;
	private String LastName;
	@NotBlank
	private String eMail;
	@NotBlank
	private String PhoneNumber;

}
