package org.nycteascandiaca.prototypes.web.presentation.gwt.client.application;

import org.nycteascandiaca.prototypes.web.presentation.gwt.client.HistoryToken;
import org.nycteascandiaca.prototypes.web.presentation.gwt.client.commands.MenuCommand;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class ApplicationView extends Composite
{
	@UiTemplate("ApplicationView.ui.xml")
	interface ApplicationViewUiBinder extends UiBinder<Widget, ApplicationView>
	{

	}

	private static ApplicationViewUiBinder uiBinder = GWT.create(ApplicationViewUiBinder.class);
	
	@UiField
	MenuBar applicationMenuBar;
	
	@UiField
	MenuItem modelMenuItem;
	
	@UiField
	MenuItem parametersMenuItem;
	
	@UiField
	SimplePanel applicationContent;
	
	public ApplicationView()
	{
		initWidget(uiBinder.createAndBindUi(this));
		
		modelMenuItem.setScheduledCommand(new MenuCommand(HistoryToken.MODEL));
		parametersMenuItem.setScheduledCommand(new MenuCommand(HistoryToken.PARAMETERS));
	}
	
	public SimplePanel getApplicationContentHolder()
	{
		return this.applicationContent;
	}
}
