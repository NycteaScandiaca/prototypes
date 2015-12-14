package org.nycteascandiaca.prototypes.web.presentation.gwt.client;

import org.nycteascandiaca.prototypes.web.presentation.gwt.client.application.ApplicationView;
import org.nycteascandiaca.prototypes.web.presentation.gwt.client.models.ModelsView;
import org.nycteascandiaca.prototypes.web.presentation.gwt.client.parameters.ParametersView;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

public interface ClientFactory
{
	public EventBus getEventBus();
	
	public PlaceController getPlaceController();
	
	public ApplicationView getApplicationView();
	
	public ModelsView getModelView();
	
	public ParametersView getParametersView();
}
