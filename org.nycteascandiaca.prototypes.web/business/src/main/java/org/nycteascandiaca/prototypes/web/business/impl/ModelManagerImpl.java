package org.nycteascandiaca.prototypes.web.business.impl;

import java.util.List;

import org.nycteascandiaca.prototypes.web.business.ModelManager;
import org.nycteascandiaca.prototypes.web.domain.Model;
import org.nycteascandiaca.prototypes.web.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ModelManagerImpl implements ModelManager
{
	@Autowired
	private ModelRepository repository;
	
	public ModelManagerImpl()
	{
		
	}
	
	public ModelManagerImpl(ModelRepository repository)
	{
		this.repository = repository;
	}

	@Override
	public List<Model> getAllModels()
	{
		return repository.findAll();
	}

	@Override
	public Model getModelById(long id)
	{
		return repository.findOne(id);
	}
	
}
