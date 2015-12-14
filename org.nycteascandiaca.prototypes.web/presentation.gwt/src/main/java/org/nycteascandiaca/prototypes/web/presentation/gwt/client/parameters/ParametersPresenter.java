package org.nycteascandiaca.prototypes.web.presentation.gwt.client.parameters;

import org.nycteascandiaca.prototypes.web.presentation.gwt.client.mvp.Presenter;

public interface ParametersPresenter extends Presenter
{
	void onGenerateButtonClick();

	void onDeleteButtonClick();
	
	void onCreateNewButtonClick();
}
