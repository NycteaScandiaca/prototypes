package org.nycteascandiaca.prototypes.web.presentation.gwt.client;

import org.nycteascandiaca.prototypes.web.presentation.gwt.client.models.ModelsPlace;
import org.nycteascandiaca.prototypes.web.presentation.gwt.client.parameters.ParametersPlace;

public enum HistoryToken
{
	MODEL (ModelsPlace.VIEW_HISTORY_TOKEN),
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
