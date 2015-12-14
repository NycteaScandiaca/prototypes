package org.nycteascandiaca.prototypes.web.presentation.gwt.client.parameters;

import java.util.Collections;
import java.util.List;

import org.nycteascandiaca.prototypes.web.domain.Parameter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.Widget;

public class ParametersViewImpl extends Composite implements ParametersView
{
	@UiTemplate("ParametersView.ui.xml")
	interface PropertiesViewUiBinder extends UiBinder<Widget, ParametersViewImpl>
	{
		
	}
	
	private static PropertiesViewUiBinder uiBinder = GWT.create(PropertiesViewUiBinder.class);
	
	@UiField
	DataGrid<Parameter> dataGrid;
	
	@UiField
	PushButton createNewButton;
	
	@UiField
	PushButton deleteButton;
	
	@UiField
	PushButton generateButton;
	
	private ParametersPresenter presenter;

	public ParametersViewImpl()
	{		
		initWidget(uiBinder.createAndBindUi(this));
		
		initializeDataGrid();
	}
	
	private void initializeDataGrid()
	{		
		TextColumn<Parameter> idColumn = new TextColumn<Parameter>()
		{
			@Override
			public String getValue(Parameter parameter)
			{
				return Long.toString(parameter.getId());
			}
		};
		dataGrid.addColumn(idColumn, "Id");
		
		TextColumn<Parameter> nameColumn = new TextColumn<Parameter>()
		{
			@Override
			public String getValue(Parameter parameter)
			{
				return parameter.getName();
			}
		};
		dataGrid.addColumn(nameColumn, "Name");
		
		TextColumn<Parameter> valueColumn = new TextColumn<Parameter>()
		{
			@Override
			public String getValue(Parameter parameter)
			{
				return parameter.getValue();
			}
		};
		dataGrid.addColumn(valueColumn, "Value");
	}
	
	@Override
	public void setPresenter(ParametersPresenter presenter)
	{
		this.presenter = presenter;
	}

	@Override
	public void setData(List<Parameter> data) {
		dataGrid.setRowCount(data.size(), false);
		dataGrid.setRowData(data);
	}

	@Override
	public List<Parameter> getSelectedData() {
		// TODO Auto-generated method stub
		return Collections.emptyList();
	}
	
	@UiHandler("createNewButton")
	void onCreateNewButtonClick(ClickEvent event)
	{
		if (presenter != null)
		{
			presenter.onCreateNewButtonClick();
		}
	}
	
	@UiHandler("deleteButton")
	void onDeleteButtonClick(ClickEvent event)
	{
		if (presenter != null)
		{
			presenter.onDeleteButtonClick();
		}
	}
	
	@UiHandler("generateButton")
	void onGenerateButtonClick(ClickEvent event)
	{
		if (presenter != null)
		{
			presenter.onGenerateButtonClick();
		}
	}
}