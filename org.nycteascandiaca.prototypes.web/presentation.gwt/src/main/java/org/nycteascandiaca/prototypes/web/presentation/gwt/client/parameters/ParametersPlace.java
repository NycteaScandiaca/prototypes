package org.nycteascandiaca.prototypes.web.presentation.gwt.client.parameters;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class ParametersPlace extends Place
{
	public static final String VIEW_HISTORY_TOKEN = "parameters";
	
	@Prefix(value = VIEW_HISTORY_TOKEN)
	public static class Tokenizer implements PlaceTokenizer<ParametersPlace>
	{
		@Override
		public ParametersPlace getPlace(String token)
		{
			return new ParametersPlace();
		}

		@Override
		public String getToken(ParametersPlace place)
		{
			return "";
		}
	}
}
