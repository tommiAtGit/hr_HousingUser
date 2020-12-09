package com.myjava.housinguser.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myjava.housinguser.domain.HousingUser;

	@Repository
	public interface UserRepository extends CrudRepository<HousingUser, UUID> {

}
