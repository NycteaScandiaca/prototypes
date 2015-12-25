package org.nycteascandiaca.prototypes.web.presentation.gwt.client.parameters;

import java.util.Map;

import org.nycteascandiaca.prototypes.web.presentation.gwt.client.mvp.TokenHelper;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class ParametersPlace extends Place
{
	public static final String VIEW_HISTORY_TOKEN = "parameters";
	
	private final Map<String, String> tokenParameters;
	
	private final String token;
	
	public ParametersPlace(String token)
	{
		this.token = token;
		this.tokenParameters = TokenHelper.getTokenParameters(token);
	}
	
	public String getToken()
	{
		return token;
	}
	
	public Long getModelId()
	{
		String value = tokenParameters.get("model");
		return value == null ? null : Long.valueOf(value);
	}
	
	@Prefix(value = VIEW_HISTORY_TOKEN)
	public static class Tokenizer implements PlaceTokenizer<ParametersPlace>
	{
		@Override
		public ParametersPlace getPlace(String token)
		{
			return new ParametersPlace(token);
		}

		@Override
		public String getToken(ParametersPlace place)
		{
			return place.getToken();
		}
	}	
}
