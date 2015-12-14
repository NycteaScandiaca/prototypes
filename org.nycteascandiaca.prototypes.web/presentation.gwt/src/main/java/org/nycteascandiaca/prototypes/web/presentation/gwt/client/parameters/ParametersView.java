package org.nycteascandiaca.prototypes.web.presentation.gwt.client.parameters;

import java.util.List;

import org.nycteascandiaca.prototypes.web.domain.Parameter;
import org.nycteascandiaca.prototypes.web.presentation.gwt.client.mvp.Display;

public interface ParametersView extends Display
{
	void setPresenter(ParametersPresenter presenter);
	
	void setData(List<Parameter> data);
	
	List<Parameter> getSelectedData();
}
