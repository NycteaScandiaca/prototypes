package org.nycteascandiaca.prototypes.web.presentation.gwt.client.mvp;

import org.nycteascandiaca.prototypes.web.presentation.gwt.client.models.ModelsPlace;
import org.nycteascandiaca.prototypes.web.presentation.gwt.client.parameters.ParametersPlace;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers
({
		ModelsPlace.Tokenizer.class,
		ParametersPlace.Tokenizer.class,
})
public interface ApplicationPlaceHistoryMapper extends PlaceHistoryMapper 
{

}
