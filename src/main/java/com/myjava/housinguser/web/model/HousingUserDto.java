package com.myjava.housinguser.web.model;

import java.util.UUID;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HousingUserDto {
	
	@NotNull
	private UUID id;
	@NotNull
	private String userName;
	@NotNull
	private String userPwd; 
	
	//private	CustomerLevel customerLevel; 
	
	private HousingUserAddressDto userAddressDto;
	
//	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",shape=JsonFormat.Shape.STRING)
//	private LocalDateTime createdDate;
//	
//	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",shape=JsonFormat.Shape.STRING)
//	private LocalDateTime lastLoginDate;
	
	
}
