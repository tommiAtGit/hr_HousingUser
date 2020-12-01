package com.myjava.housinguser.housingUser.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myjava.housinguser.housingUser.domain.HousingUser;

	@Repository
	public interface UserRepository extends CrudRepository<HousingUser, UUID> {

}
