package org.nycteascandiaca.prototypes.web.presentation.gwt.client;

import org.nycteascandiaca.prototypes.web.presentation.gwt.client.application.ApplicationView;
import org.nycteascandiaca.prototypes.web.presentation.gwt.client.models.ModelsView;
import org.nycteascandiaca.prototypes.web.presentation.gwt.client.models.ModelsViewImpl;
import org.nycteascandiaca.prototypes.web.presentation.gwt.client.parameters.ParametersView;
import org.nycteascandiaca.prototypes.web.presentation.gwt.client.parameters.ParametersViewImpl;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

public class ClientFactoryImpl implements ClientFactory
{
	private static final EventBus EVENT_BUS = new SimpleEventBus();
	
	private static final PlaceController PLACE_CONTROLLER = new PlaceController(EVENT_BUS);
	
	private static final ApplicationView APPLICATION_VIEW = new ApplicationView();

	private static final ModelsView MODEL_VIEW = new ModelsViewImpl();
	
	private static final ParametersView PARAMETERS_VIEW = new ParametersViewImpl();	

	@Override
	public EventBus getEventBus()
	{
		return EVENT_BUS;
	}

	@Override
	public PlaceController getPlaceController()
	{
		return PLACE_CONTROLLER;
	}

	@Override
	public ApplicationView getApplicationView()
	{
		return APPLICATION_VIEW;
	}

	@Override
	public ModelsView getModelView()
	{
		return MODEL_VIEW;
	}

	@Override
	public ParametersView getParametersView()
	{
		return PARAMETERS_VIEW;
	}

}
