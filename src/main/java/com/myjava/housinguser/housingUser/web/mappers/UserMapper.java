package com.myjava.housinguser.housingUser.web.mappers;

import com.myjava.housinguser.housingUser.domain.HousingUser;
import com.myjava.housinguser.housingUser.web.model.HousingUserDto;

public interface UserMapper {

	HousingUserDto HousingUsertoDto(HousingUser housdingUser);
	HousingUser DtoToHousingUser(HousingUserDto dto);
}
