package com.myjava.housinguser.housingUser.web.model;

import java.time.OffsetDateTime;
import java.util.UUID;

import javax.validation.constraints.NotNull;
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
public class HousingUserDto {
	
	@Null
	private UUID id;
	@NotNull
	private String userName;
	@NotNull
	private String userPwd; 
	
	private	CustomerLevel customerLevel; 
	
	private HousingUserAddressDto userAddress;
	@Null
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss2",shape=JsonFormat.Shape.STRING)
	private OffsetDateTime createdDate;
	
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss2",shape=JsonFormat.Shape.STRING)
	private OffsetDateTime lastLoginDate;
}
