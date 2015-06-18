package com.unep.wcmc.service;

import org.springframework.stereotype.Service;

import com.unep.wcmc.model.Gender;
import com.unep.wcmc.repository.GenusRepository;

@Service
public class GenusService extends AbstractService<Gender, GenusRepository> {
}
