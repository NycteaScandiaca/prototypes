package org.nycteascandiaca.prototypes.web.presentation.gwt.client.models;

import java.util.List;

import org.nycteascandiaca.prototypes.web.domain.Model;
import org.nycteascandiaca.prototypes.web.presentation.gwt.client.mvp.Display;

public interface ModelsView extends Display
{
	void setPresenter(ModelsPresenter presenter);
	
	void setData(List<Model> data);
	
	List<Model> getSelectedData();
}
