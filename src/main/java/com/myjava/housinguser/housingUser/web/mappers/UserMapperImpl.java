package com.myjava.housinguser.housingUser.web.mappers;

import com.myjava.housinguser.housingUser.domain.HousingUser;
import com.myjava.housinguser.housingUser.domain.HousingUserAddress;
import com.myjava.housinguser.housingUser.web.model.CustomerLevel;
import com.myjava.housinguser.housingUser.web.model.HousingUserAddressDto;
import com.myjava.housinguser.housingUser.web.model.HousingUserDto;

public class UserMapperImpl implements UserMapper{

	@Override
	public HousingUserDto HousingUsertoDto(HousingUser housingUser) {
		
		HousingUserAddressDto userAddress = HousingUserAddressDto.builder()
				.id(housingUser.getUserAddress().getId())
				.FirstName(housingUser.getUserAddress().getFirstName())
				.LastName(housingUser.getUserAddress().getLastName())
				.eMail(housingUser.getUserAddress().getEMail())
				.PhoneNumber(housingUser.getUserAddress().getPhoneNumber())
				.createdDate(housingUser.getUserAddress().getCreatedDate())
				.build();
		
		HousingUserDto userDto = HousingUserDto.builder()
				.id(housingUser.getId())
				.userName(housingUser.getUserName())
				.userPwd(housingUser.getUserPwd())
				.customerLevel(CustomerLevel.valueOf(housingUser.getCustomerLevel()))
				.createdDate(housingUser.getCreatedDate())
				.userAddress(userAddress)
				.build();
		
		return userDto;
	}

	@Override
	public HousingUser DtoToHousingUser(HousingUserDto dto) {
		
		HousingUserAddress userAddress = HousingUserAddress.builder()
				.id(dto.getUserAddress().getId())
				.FirstName(dto.getUserAddress().getFirstName())
				.LastName(dto.getUserAddress().getLastName())
				.eMail(dto.getUserAddress().getEMail())
				.PhoneNumber(dto.getUserAddress().getPhoneNumber())
				.createdDate(dto.getUserAddress().getCreatedDate())
				.build();
		
		HousingUser userDto = HousingUser.builder()
				.id(dto.getId())
				.userName(dto.getUserName())
				.userPwd(dto.getUserPwd())
				.customerLevel(dto.getCustomerLevel().toString())
				.createdDate(dto.getCreatedDate())
				.userAddress(userAddress)
				.build();
		
		return userDto;
	}

}
