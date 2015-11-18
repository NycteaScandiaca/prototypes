package org.nycteascandiaca.prototypes.web.presentation.client.parameters;

import java.util.ArrayList;
import java.util.List;

import org.nycteascandiaca.prototypes.web.domain.Parameter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ParametersView extends Composite
{
	@UiTemplate("ParametersView.ui.xml")
	interface PropertiesViewUiBinder extends UiBinder<Widget, ParametersView>
	{
		
	}
	
	private static PropertiesViewUiBinder uiBinder = GWT.create(PropertiesViewUiBinder.class);
	
	private ParametersPresenter presenter;

	public ParametersView()
	{
		initWidget(uiBinder.createAndBindUi(this));
    }

	public void setPresenter(ParametersPresenter presenter)
	{
		this.presenter = presenter;
	}
}