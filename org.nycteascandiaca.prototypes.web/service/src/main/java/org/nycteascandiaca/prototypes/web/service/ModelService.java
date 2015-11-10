package org.nycteascandiaca.prototypes.web.service;

import java.util.List;

import org.nycteascandiaca.prototypes.web.business.ModelManager;
import org.nycteascandiaca.prototypes.web.domain.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModelService
{
	private ModelManager modelManager;
	
	@RequestMapping("/models")
	public List<Model> getAllModels()
	{
		return modelManager.getAllModels();
	}
	
	public Model getModelById(long id)
	{
		return modelManager.getModelById(id);
	}
}
