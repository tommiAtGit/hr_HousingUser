package com.myjava.housinguser.housingUser.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myjava.housinguser.web.controller.HousingUserController;
import com.myjava.housinguser.web.model.HousingUserAddressDto;
import com.myjava.housinguser.web.model.HousingUserDto;
import com.myjava.housinguser.web.service.HousingUserService;


@WebMvcTest(HousingUserController.class)
public class HousingUserControllerTest {

	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@MockBean
	HousingUserService userService;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	
	@Test
	void getUserByUserName() throws Exception {
		given(userService.getByUserName(any())).willReturn(createHousingUser());
		
		mockMvc.perform(get("/api/housinguser/"+UUID.randomUUID().toString())
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());	    
	}
	
	@Test
	void saveHousingUserTest() throws Exception {
		HousingUserDto housingUserDto = createHousingUser();
		String userJson = objectMapper.writeValueAsString(housingUserDto);
		
		given(userService.saveHousingUser(any())).willReturn(createHousingUser());
		
		mockMvc.perform(post("/api/housinguser")
				.contentType(MediaType.APPLICATION_JSON)
				.content(userJson))
				.andExpect(status().isCreated());
	}
	
	private HousingUserDto createHousingUser() {
		
		HousingUserAddressDto userAddress = HousingUserAddressDto.builder()
				.id(UUID.randomUUID())
				.FirstName("TommiPommi")
				.LastName("Peräpukama")
				.eMail("tommi@pommi.com")
				.PhoneNumber("555-123234")
				//.createdDate(OffsetDateTime.now())
				.build();
		
		HousingUserDto user = HousingUserDto.builder()
				.id(UUID.randomUUID())
				.userName("PommiTest")
				.userPwd("PommiPass")
				//.customerLevel(CustomerLevel.WRITER)
				.userAddressDto(userAddress)
				//.createdDate(OffsetDateTime.now())
				//.lastLoginDate(OffsetDateTime.now())
				.build();
		
		return user;
	}
}
