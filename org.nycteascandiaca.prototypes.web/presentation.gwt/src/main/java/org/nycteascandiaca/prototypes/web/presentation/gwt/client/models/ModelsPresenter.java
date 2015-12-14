package org.nycteascandiaca.prototypes.web.presentation.gwt.client.models;

import org.nycteascandiaca.prototypes.web.presentation.gwt.client.mvp.Presenter;

public interface ModelsPresenter extends Presenter
{
	void onEditButtonClick();

	void onDeleteButtonClick();
	
	void onCreateNewButtonClick();
}
