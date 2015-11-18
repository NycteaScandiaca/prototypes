package org.nycteascandiaca.prototypes.web.presentation.client.model;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class ModelPlace extends Place
{
	public static final String VIEW_HISTORY_TOKEN = "model";
	
	@Prefix(value = VIEW_HISTORY_TOKEN)
	public static class Tokenizer implements PlaceTokenizer<ModelPlace>
	{
		@Override
		public ModelPlace getPlace(String token)
		{
			return new ModelPlace();
		}

		@Override
		public String getToken(ModelPlace place)
		{
			return "";
		}
	}
}
