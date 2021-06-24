package com.form.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.form.entity.NewUserEntry;
import com.form.repo.InterfaceNUE;

@Controller
public class ControllerClass {
	
	
	@Autowired
	InterfaceNUE repo;
	@Autowired
	NewUserEntry nue;

	
	@RequestMapping("/")
	public String create(Model model) 
	{
		//model accepts key value pairs one is string attribute and other is empty object
		model.addAttribute("newEntry",nue);
		//we are passing newEntry key to index.html to get the responses
		return "index";
	}
	
	
	@RequestMapping(path = "/createNewRecord", method = RequestMethod.POST)
	public String createNewEntry(NewUserEntry newEntry,Model model) 
	{
	
		//it will save the data into the database and return a object of that entry
		NewUserEntry entry = repo.save(newEntry);
		//for edit purpose we are adding the returned object of added database object to display html
		model.addAttribute("newEntry", entry);
		return "display";
	}

	//when user clicks edit we will redirected to this with id
	@RequestMapping(path ="/edit/{id}")
	public String updateEntry(Model model, @PathVariable("id") Integer id) 
							
	{
		NewUserEntry entity = repo.findById(id).orElse(null);
		model.addAttribute("newEntry", entity);
		return "index";
	}
	

	
	
	
	
}