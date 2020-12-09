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
	public HousingUserDto getById(UUID userId) {
		
		List<HousingUser> users = (List<HousingUser>) repository.findAll();
		
		for (HousingUser housingUser : users) {
			if (housingUser.getId().equals(userId)) {
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
			hU.setCustomerLevel(userDto.getCustomerLevel().name());
			HousingUserAddress userAddress = HousingUserAddress.builder()
					.id(userDto.getUserAddress().getId())
					.FirstName(userDto.getUserAddress().getFirstName())
					.LastName(userDto.getUserAddress().getLastName())
					.eMail(userDto.getUserAddress().getEMail())
					.PhoneNumber(userDto.getUserAddress().getPhoneNumber())
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
