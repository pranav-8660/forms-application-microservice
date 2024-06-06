package com.pranavv51.formsapplication.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Keys-database")
public class FormModelKeys {

	@Id
	private String id;
	private ArrayList<String> keyList = new ArrayList<String>();

	public FormModelKeys(String id,ArrayList<String> keyList) {
		super();
		this.id=id;
		this.keyList = keyList;
	}
	
	public FormModelKeys() {
		super();
	}
	
	public FormModelKeys(String idString) {
		super();
		this.id = idString;
	}

	public ArrayList<String> getKeyList() {
		return keyList;
	}

	public void setKeyList(ArrayList<String> keyList) {
		this.keyList = keyList;
	}

	public String getIdString() {
		return id;
	}

	public void setIdString(String idString) {
		this.id = idString;
	}
	
}
