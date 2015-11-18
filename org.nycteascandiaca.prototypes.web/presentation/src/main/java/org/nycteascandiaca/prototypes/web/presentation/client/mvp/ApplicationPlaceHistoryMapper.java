package org.nycteascandiaca.prototypes.web.presentation.client.mvp;

import org.nycteascandiaca.prototypes.web.presentation.client.model.ModelPlace;
import org.nycteascandiaca.prototypes.web.presentation.client.parameters.ParametersPlace;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers
({
		ModelPlace.Tokenizer.class,
		ParametersPlace.Tokenizer.class,
})
public interface ApplicationPlaceHistoryMapper extends PlaceHistoryMapper 
{

}
