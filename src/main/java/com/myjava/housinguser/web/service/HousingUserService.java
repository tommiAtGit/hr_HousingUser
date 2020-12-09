package com.myjava.housinguser.web.service;

import java.util.UUID;

import com.myjava.housinguser.web.model.HousingUserDto;

public interface HousingUserService {
	
	HousingUserDto getById(UUID userId);
	HousingUserDto getByUserName(String username);
	HousingUserDto saveHousingUser(HousingUserDto userDto);
	HousingUserDto updateHousingUser(UUID id, HousingUserDto userDto);
	void deleteHousingUser(HousingUserDto userDto);
	
	
	

}
