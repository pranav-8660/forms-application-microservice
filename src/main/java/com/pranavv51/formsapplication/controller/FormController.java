package com.pranavv51.formsapplication.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.bson.codecs.ValueCodecProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pranavv51.formsapplication.model.FormModelKeys;
import com.pranavv51.formsapplication.model.FormModelValues;
import com.pranavv51.formsapplication.service.FormService;

@RestController
@RequestMapping(value="/form-mining")
public class FormController {
	
	private final FormService serviceInst;
	
	public FormController(FormService serviceInst) {
		super();
		this.serviceInst = serviceInst;
	}
	
	@PostMapping(value="/create-a-form/id/{id}")
	@CrossOrigin
	public String getListofKeys(@RequestBody ArrayList<String> keyList,@PathVariable String id) {
		return serviceInst.addKeys(keyList,id);
	}

	@GetMapping("/retrieve-listOf-keys/id/{id}")
	@CrossOrigin
	public ResponseEntity<FormModelKeys> retrieveListKeys(@PathVariable String id){
		return ResponseEntity.ok(serviceInst.getAllValues(id));
	}
	
	@PostMapping("/respond-to-form/creator/{id1}/responder/{id2}")
	@CrossOrigin
	public String getListOfValues(@RequestBody ArrayList<String> keyList,@PathVariable String id1,@PathVariable String id2) {
		return serviceInst.addValues(keyList,id1,id2);
	}
	
	@GetMapping(value="/retrieve-listOf-responses/formCreator/{formcreator}")
	@CrossOrigin
	public ResponseEntity<ArrayList<FormModelValues>> getListOfAllResponses(@PathVariable String formcreator) {
		return ResponseEntity.ok(serviceInst.retrieveonlyForResponses(formcreator));
	}

}
