package com.myjava.housinguser.web.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myjava.housinguser.web.model.HousingUserDto;
import com.myjava.housinguser.web.service.HousingUserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/housinguser")
@RestController
public class HousingUserController {
	
	private final HousingUserService housingUserService;
	
	@GetMapping("/{username}")
	public ResponseEntity<HousingUserDto>getCooperativeByUserName(@PathVariable("username")String username){
		log.info("Get user called by username: " + username);
		
		return new ResponseEntity<HousingUserDto>(housingUserService.getByUserName(username),HttpStatus.OK);
	}
	
	
	
	@PostMapping
	public ResponseEntity<HousingUserDto>saveHousingUser( @Validated @RequestBody HousingUserDto hcUDto){
		
		log.info("New housing user added with name: " + hcUDto.getUserName());
		return new ResponseEntity<HousingUserDto>(housingUserService.saveHousingUser(hcUDto),HttpStatus.CREATED);
	
	}
	
	@PutMapping("/user/{userId}")
	public ResponseEntity<HousingUserDto>updateHousingUser(@PathVariable (value ="userId")UUID userId,
			@Valid @RequestBody HousingUserDto uDto){
			
		log.info("Update housing user with userid: "+ userId);
		
		return new ResponseEntity<HousingUserDto>(housingUserService.updateHousingUser(userId, uDto),HttpStatus.FOUND);
		
	}
	
	@DeleteMapping("/user")
	public void deleteHousingUser(@Valid @RequestBody HousingUserDto uDto) {
		
		housingUserService.deleteHousingUser(uDto);
	}

}
