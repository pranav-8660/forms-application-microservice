package com.pranavv51.formsapplication.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pranavv51.formsapplication.model.FormModelKeys;
import com.pranavv51.formsapplication.model.FormModelValues;


@Service
public class FormService {
	
	private final FormInterface keyInterface;
	private final FormValueInterface valueInterface;
	
	public FormService(FormInterface keyInterface,FormValueInterface valueInterface) {
		super();
		this.keyInterface = keyInterface;
		this.valueInterface=valueInterface;
	}

	//id here tells who has created the form
	public String addKeys(ArrayList<String> listOfKeys,String id) {
		
		keyInterface.insert(new FormModelKeys(id,listOfKeys));
		
		return "Successfully created the desired form!";
		
	}
	
	public FormModelKeys getAllValues(String id){
		
		List<FormModelKeys> allKeys = new ArrayList<FormModelKeys>();
		allKeys = keyInterface.findAll();
		
		for(FormModelKeys all:allKeys) {
			if(all.getIdString().equals(id))
				return all;
		}
		return new FormModelKeys();
	}
	
	
	//id here tells who/who all has/have responded
	public String addValues(ArrayList<String> listOfValues,String formCreator,String formResponder) {
		
		FormModelKeys tempScratch = getAllValues(formCreator);
		ArrayList<String> scratchArraylist = new ArrayList<String>();
		scratchArraylist = tempScratch.getKeyList();
		
		HashMap<String, String> scratcHashMap = new HashMap<String, String>();
		
		Iterator<String> itrIteratorkey = scratchArraylist.iterator();
		Iterator<String> itrIteratorval = listOfValues.iterator();
		
		
		while(itrIteratorval.hasNext()) {
			scratcHashMap.put(itrIteratorkey.next(),itrIteratorval.next() );
		}
		
		valueInterface.insert(new FormModelValues(formCreator,formResponder,scratcHashMap));
		
		return "Thanks a lot "+formResponder+" for responding";	
		}
	
	private ArrayList<FormModelValues> retrieveAllFormResponses(String formCeator) {
		
		List<FormModelValues> allResponses = valueInterface.findAll();
		ArrayList<FormModelValues> scratchList = new ArrayList<>();
		for(FormModelValues tempInst : allResponses) {
			if(tempInst.getFormCreator().equals(formCeator)) {
				scratchList.add(tempInst);
			}
		}
		return scratchList;
	}
	
	public ArrayList<FormModelValues> retrieveonlyForResponses(String formCeator) {
		
		return retrieveAllFormResponses(formCeator);
		
	}

}
