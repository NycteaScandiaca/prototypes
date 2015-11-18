package org.nycteascandiaca.prototypes.web.presentation.client;

import org.nycteascandiaca.prototypes.web.presentation.client.model.ModelPlace;
import org.nycteascandiaca.prototypes.web.presentation.client.parameters.ParametersPlace;

public enum HistoryToken
{
	MODEL (ModelPlace.VIEW_HISTORY_TOKEN),
	PARAMETERS (ParametersPlace.VIEW_HISTORY_TOKEN);
	
	private final String token;
	
	HistoryToken(String token)
	{
		this.token = token + ":";
	}
	
	public String getToken()
	{
		return token;
	}
}
