package org.nycteascandiaca.prototypes.web.presentation.gwt.client.mvp;

import org.nycteascandiaca.prototypes.web.presentation.gwt.client.ClientFactory;
import org.nycteascandiaca.prototypes.web.presentation.gwt.client.models.ModelsPresenterImpl;
import org.nycteascandiaca.prototypes.web.presentation.gwt.client.models.ModelsPlace;
import org.nycteascandiaca.prototypes.web.presentation.gwt.client.parameters.ParametersPresenterImpl;
import org.nycteascandiaca.prototypes.web.presentation.gwt.client.parameters.ParametersPlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class ApplicationActivityMapper implements ActivityMapper
{
	private final ClientFactory clientFactory;

	public ApplicationActivityMapper(ClientFactory clientFactory)
	{
		this.clientFactory = clientFactory;
	}
	
	@Override
	public Activity getActivity(Place place)
	{
		if (place instanceof ModelsPlace)
		{
			return new ModelsPresenterImpl((ModelsPlace)place, clientFactory);
		}
		else if (place instanceof ParametersPlace)
		{
			return new ParametersPresenterImpl((ParametersPlace)place, clientFactory);
		}
		return null;
	}
}
