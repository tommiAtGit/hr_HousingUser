package com.myjava.housinguser.housingUser.web.service;

import java.util.UUID;

import com.myjava.housinguser.housingUser.web.model.HousingUserDto;

public interface HousingUserService {
	
	HousingUserDto getUserById(UUID id);
	HousingUserDto saveHousingUser(HousingUserDto userDto);
	HousingUserDto updateHousingUser(UUID id, HousingUserDto userDto);
	
	
	

}
