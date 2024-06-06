package com.pranavv51.formsapplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pranavv51.formsapplication.model.FormModelValues;

public interface FormValueInterface extends MongoRepository<FormModelValues, String>{

	
	
}
