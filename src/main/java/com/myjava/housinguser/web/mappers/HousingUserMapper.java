package com.myjava.housinguser.web.mappers;

import org.mapstruct.Mapper;

import com.myjava.housinguser.domain.HousingUser;
import com.myjava.housinguser.web.model.HousingUserDto;

@Mapper(uses= {DateMapper.class})
public interface HousingUserMapper {

	HousingUserDto HousingUsertoDto(HousingUser housingUser);
	
	HousingUser DtoToHousingUser(HousingUserDto dto);
}
