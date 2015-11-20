package org.nycteascandiaca.prototypes.web.business;

import java.util.List;

import org.nycteascandiaca.prototypes.web.domain.Model;
import org.nycteascandiaca.prototypes.web.domain.Parameter;

public interface ModelManager
{
	List<Model> getAllModels();
	
	Model getModelById(long id);
	
	Model createNewModel(String name);
	
	Parameter createParameter(Model model, String name, String value);
	
	void removeParameter(Parameter parameter);
}
