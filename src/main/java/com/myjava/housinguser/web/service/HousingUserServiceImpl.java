package com.myjava.housinguser.web.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.myjava.housinguser.domain.HousingUser;
import com.myjava.housinguser.domain.HousingUserAddress;
import com.myjava.housinguser.repositories.UserRepository;
import com.myjava.housinguser.web.mappers.HousingUserMapper;
import com.myjava.housinguser.web.model.HousingUserDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class HousingUserServiceImpl implements HousingUserService{

	private final HousingUserMapper mapper;
	private final UserRepository repository;

	
	@Override
	public HousingUserDto getById(String userId) {
		
		List<HousingUser> users = (List<HousingUser>) repository.findAll();
		
		for (HousingUser housingUser : users) {
			if (housingUser.getId().toString().equals(userId)) {
				return mapper.HousingUsertoDto(housingUser);
			}
		}
		return null;
		
	}

	@Override
	public HousingUserDto getByUserName(String username) {
		List<HousingUser> users = (List<HousingUser>) repository.findAll();
		
		for (HousingUser housingUser : users) {
			if (housingUser.getId() == UUID.fromString(username)) {
				return mapper.HousingUsertoDto(housingUser);
			}
		}
		log.info("User not found with username: " + username);
		return null;
	}

	@Override
	public HousingUserDto saveHousingUser(HousingUserDto userDto) {
		if (userDto != null) {
			return mapper.HousingUsertoDto(
					repository.save(mapper.DtoToHousingUser(userDto)));
		}
		else {
			throw new NullPointerException();
		}
		
	}

	@Override
	public HousingUserDto updateHousingUser(UUID id, HousingUserDto userDto) {
		if (userDto != null) {
			HousingUser hU = repository.findById(id).orElseThrow();
			//hU.setCustomerLevel(userDto.getCustomerLevel().name());
			HousingUserAddress userAddress = HousingUserAddress.builder()
					.id(userDto.getUserAddressDto().getId())
					.firstName(userDto.getUserAddressDto().getFirstName())
					.lastName(userDto.getUserAddressDto().getLastName())
					.eMail(userDto.getUserAddressDto().getEMail())
					.phoneNumber(userDto.getUserAddressDto().getPhoneNumber())
					.build();
			hU.setUserAddress(userAddress);
			hU.setUserName(userDto.getUserName());
			hU.setUserPwd(userDto.getUserPwd());
			
			return mapper.HousingUsertoDto(repository.save(hU));
		}
		else {
			return null;
		}
	}
	
	@Override
	public void deleteHousingUser(HousingUserDto userDto) {
		
		repository.delete(mapper.DtoToHousingUser(userDto));
	}
	

}
