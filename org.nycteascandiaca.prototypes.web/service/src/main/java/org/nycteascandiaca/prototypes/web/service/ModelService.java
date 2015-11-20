package org.nycteascandiaca.prototypes.web.service;

import java.util.List;

import org.nycteascandiaca.prototypes.web.business.ModelManager;
import org.nycteascandiaca.prototypes.web.domain.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/models")
public class ModelService
{
	@Autowired
	private ModelManager modelManager;
	
	@RequestMapping
	public List<Model> getAllModels()
	{
		return modelManager.getAllModels();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Model getModelById(@PathVariable("id") int id)
	{
		return modelManager.getModelById(id);
	}
}
