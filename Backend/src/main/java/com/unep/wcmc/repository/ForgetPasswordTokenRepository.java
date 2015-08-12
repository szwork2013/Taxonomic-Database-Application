package com.unep.wcmc.repository;

import org.springframework.data.repository.CrudRepository;

import com.unep.wcmc.model.ForgetPasswordToken;

public interface ForgetPasswordTokenRepository extends CrudRepository<ForgetPasswordToken, Long> {
	
	ForgetPasswordToken findByToken(String token);
}
