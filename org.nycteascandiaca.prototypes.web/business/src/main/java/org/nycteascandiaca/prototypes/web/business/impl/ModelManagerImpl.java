package org.nycteascandiaca.prototypes.web.business.impl;

import java.util.List;

import org.nycteascandiaca.prototypes.web.business.ModelManager;
import org.nycteascandiaca.prototypes.web.domain.Model;
import org.nycteascandiaca.prototypes.web.repository.ModelRepository;

public class ModelManagerImpl implements ModelManager
{
	private final ModelRepository repository;
	
	ModelManagerImpl(ModelRepository repository)
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
