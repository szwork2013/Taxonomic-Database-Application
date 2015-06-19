package com.unep.wcmc.service;

import org.springframework.stereotype.Service;

import com.unep.wcmc.model.Gender;
import com.unep.wcmc.repository.GenderRepository;

@Service
public class GenderService extends AbstractService<Gender, GenderRepository> {
}
