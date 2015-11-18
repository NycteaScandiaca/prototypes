package org.nycteascandiaca.prototypes.web.presentation.client;

import org.nycteascandiaca.prototypes.web.presentation.client.application.ApplicationView;
import org.nycteascandiaca.prototypes.web.presentation.client.model.ModelView;
import org.nycteascandiaca.prototypes.web.presentation.client.parameters.ParametersView;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

public class ClientFactoryImpl implements ClientFactory
{
	private static final EventBus EVENT_BUS = new SimpleEventBus();
	
	private static final PlaceController PLACE_CONTROLLER = new PlaceController(EVENT_BUS);
	
	private static final ApplicationView APPLICATION_VIEW = new ApplicationView();

	private static final ModelView MODEL_VIEW = new ModelView();
	
	private static final ParametersView PARAMETERS_VIEW = new ParametersView();	

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
	public ModelView getModelView()
	{
		return MODEL_VIEW;
	}

	@Override
	public ParametersView getParametersView()
	{
		return PARAMETERS_VIEW;
	}

}
