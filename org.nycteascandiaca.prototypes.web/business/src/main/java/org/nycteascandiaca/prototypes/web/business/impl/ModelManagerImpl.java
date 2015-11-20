package org.nycteascandiaca.prototypes.web.business.impl;

import java.util.List;

import org.nycteascandiaca.prototypes.web.business.ModelManager;
import org.nycteascandiaca.prototypes.web.domain.Model;
import org.nycteascandiaca.prototypes.web.domain.Parameter;
import org.nycteascandiaca.prototypes.web.repository.ModelRepository;
import org.nycteascandiaca.prototypes.web.repository.ParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ModelManagerImpl implements ModelManager
{
	@Autowired
	private ModelRepository modelRepository;
	
	@Autowired
	private ParameterRepository parameterRepository;
	
	public ModelManagerImpl()
	{
		
	}
	
	public ModelManagerImpl(ModelRepository modelRepository, ParameterRepository parameterRepository)
	{
		this.modelRepository = modelRepository;
		this.parameterRepository = parameterRepository;
	}

	@Override
	public List<Model> getAllModels()
	{
		return modelRepository.findAll();
	}

	@Override
	public Model getModelById(long id)
	{
		return modelRepository.findOne(id);
	}

	@Override
	public Model createNewModel(String name)
	{
		Model model = new Model();
		model.setName(name);
		
		return modelRepository.save(model);
	}

	@Override
	public Parameter createParameter(Model model, String name, String value)
	{
		Parameter parameter = new Parameter();
		parameter.setName(name);
		parameter.setValue(value);
		
		model.getParameters().add(parameter);
		
		try
		{
			modelRepository.save(model);
		}
		catch (Throwable e)
		{
			model.getParameters().remove(parameter);
		}
		
		return parameter;
	}

	@Override
	public void removeParameter(Parameter parameter)
	{
		parameterRepository.delete(parameter);
	}
}
