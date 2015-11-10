package org.nycteascandiaca.prototypes.web.business;

import java.util.List;

import org.nycteascandiaca.prototypes.web.domain.Model;

public interface ModelManager
{
	List<Model> getAllModels();
	
	Model getModelById(long id);
}
