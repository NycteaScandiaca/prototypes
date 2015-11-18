package org.nycteascandiaca.prototypes.web.presentation.client.model;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class ModelView extends Composite
{	
	@UiTemplate("ModelView.ui.xml")
	interface HomeViewUiBinder extends UiBinder<Widget, ModelView>
	{
		
	}
	
	private static HomeViewUiBinder uiBinder = GWT.create(HomeViewUiBinder.class);
	
	@UiField
	TextBox modelNameTextBox;
	
	@UiField
	Button applyButton;
	
	private ModelPresenter presenter;

	public ModelView()
	{
		initWidget(uiBinder.createAndBindUi(this));
    }

	public void setPresenter(ModelPresenter presenter)
	{
		this.presenter = presenter;
	}
	
	@UiHandler("applyButton")
	void onApplyButtonClick(ClickEvent event)
	{
		if (presenter != null)
		{
			presenter.onApplyButtonClick();
		}
	}
}
