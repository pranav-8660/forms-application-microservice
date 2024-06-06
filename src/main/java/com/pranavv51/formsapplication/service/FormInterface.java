package com.pranavv51.formsapplication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pranavv51.formsapplication.model.FormModelKeys;
import com.pranavv51.formsapplication.model.FormModelValues;

public interface FormInterface extends MongoRepository<FormModelKeys, ArrayList<String>> {
	
	
	
}
