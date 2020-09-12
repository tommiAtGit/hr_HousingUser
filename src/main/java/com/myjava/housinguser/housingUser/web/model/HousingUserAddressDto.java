package com.myjava.housinguser.housingUser.web.model;

import java.time.OffsetDateTime;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	@Null
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss2",shape=JsonFormat.Shape.STRING)
	private OffsetDateTime createdDate;
	
}
