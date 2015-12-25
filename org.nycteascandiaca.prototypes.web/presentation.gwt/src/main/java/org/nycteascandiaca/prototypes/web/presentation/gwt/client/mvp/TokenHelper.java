package org.nycteascandiaca.prototypes.web.presentation.gwt.client.mvp;

import java.util.HashMap;

public class TokenHelper
{
	public static HashMap<String, String> getTokenParameters(String historyToken)
	{
		HashMap<String, String> params = new HashMap<String, String>();
		
		String[] parameters = historyToken.split("&");
		for (int i = 0; i < parameters.length; i++)
		{
			String[] parameter = parameters[i].split("=");
			params.put(parameter[0], parameter[1]);
		}

		return params;
	}
}
