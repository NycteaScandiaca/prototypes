package org.nycteascandiaca.prototypes.web.presentation.gwt.client.models;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class ModelsPlace extends Place
{
	public static final String VIEW_HISTORY_TOKEN = "models";
	
	@Prefix(value = VIEW_HISTORY_TOKEN)
	public static class Tokenizer implements PlaceTokenizer<ModelsPlace>
	{
		@Override
		public ModelsPlace getPlace(String token)
		{
			return new ModelsPlace();
		}

		@Override
		public String getToken(ModelsPlace place)
		{
			return "";
		}
	}
}
