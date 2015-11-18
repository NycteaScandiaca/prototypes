package org.nycteascandiaca.prototypes.web.presentation.client.mvp;

import org.nycteascandiaca.prototypes.web.presentation.client.ClientFactory;
import org.nycteascandiaca.prototypes.web.presentation.client.model.ModelActivity;
import org.nycteascandiaca.prototypes.web.presentation.client.model.ModelPlace;
import org.nycteascandiaca.prototypes.web.presentation.client.parameters.ParametersActivity;
import org.nycteascandiaca.prototypes.web.presentation.client.parameters.ParametersPlace;

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
		if (place instanceof ModelPlace)
		{
			return new ModelActivity(clientFactory);
		}
		else if (place instanceof ParametersPlace)
		{
			return new ParametersActivity(clientFactory);
		}
		return null;
	}
}
