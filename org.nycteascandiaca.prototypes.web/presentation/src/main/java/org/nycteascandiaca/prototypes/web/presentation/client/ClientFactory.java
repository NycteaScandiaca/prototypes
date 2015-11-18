package org.nycteascandiaca.prototypes.web.presentation.client;

import org.nycteascandiaca.prototypes.web.presentation.client.application.ApplicationView;
import org.nycteascandiaca.prototypes.web.presentation.client.model.ModelView;
import org.nycteascandiaca.prototypes.web.presentation.client.parameters.ParametersView;

import com.google.web.bindery.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;

public interface ClientFactory
{
	public EventBus getEventBus();
	
	public PlaceController getPlaceController();
	
	public ApplicationView getApplicationView();
	
	public ModelView getModelView();
	
	public ParametersView getParametersView();
}
