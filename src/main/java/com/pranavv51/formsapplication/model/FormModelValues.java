package com.pranavv51.formsapplication.model;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Values-database")
public class FormModelValues {
	
	@Id
	private String FormResponder;
	private String formCreator;
	

	private HashMap<String,String> mapsHashMap = new HashMap<String, String>();
	
	public FormModelValues() {
		super();
	}
	public FormModelValues(String formCreator,String FormResponder, HashMap<String, String> mapsHashMap) {
		super();
		this.formCreator = formCreator;
		this.FormResponder=FormResponder;
		this.mapsHashMap = mapsHashMap;
	}
	public String getFormCreator() {
		return formCreator;
	}
	public void setFormCreator(String formCreator) {
		this.formCreator = formCreator;
	}
	public String getFormResponder() {
		return FormResponder;
	}
	public void setFormResponder(String formResponder) {
		FormResponder = formResponder;
	}
	public HashMap<String, String> getMapsHashMap() {
		return mapsHashMap;
	}
	public void setMapsHashMap(HashMap<String, String> mapsHashMap) {
		this.mapsHashMap = mapsHashMap;
	}
	
}
