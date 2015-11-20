package org.nycteascandiaca.prototypes.web.presentation.client.parameters;

import java.util.ArrayList;
import java.util.List;

import org.nycteascandiaca.prototypes.web.presentation.shared.ParameterInfo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.Widget;

public class ParametersView extends Composite
{
	@UiTemplate("ParametersView.ui.xml")
	interface PropertiesViewUiBinder extends UiBinder<Widget, ParametersView>
	{
		
	}
	
	private static PropertiesViewUiBinder uiBinder = GWT.create(PropertiesViewUiBinder.class);
	
	@UiField
	DataGrid<ParameterInfo> dataGrid;
	
	@UiField
	PushButton createNewButton;
	
	@UiField
	PushButton removeAllButton;
	
	@UiField
	PushButton generateButton;
	
	private ParametersPresenter presenter;

	public ParametersView()
	{		
		initWidget(uiBinder.createAndBindUi(this));
		
		initializePropertiesGrid();
	}
	
	private void initializePropertiesGrid()
	{
		List<ParameterInfo> parameters = new ArrayList<ParameterInfo>();
		for (int i = 0; i < 1000; i++)
		{
			ParameterInfo parameter = new ParameterInfo();
			parameter.setId(Long.valueOf(i));
			parameter.setName("Name " + i);
			parameter.setValue("Value " + i);
			parameters.add(parameter);
		}
		
		TextColumn<ParameterInfo> idColumn = new TextColumn<ParameterInfo>()
		{
			@Override
			public String getValue(ParameterInfo parameter)
			{
				return parameter.getId().toString();
			}
		};
		dataGrid.addColumn(idColumn, "Id");
		
		TextColumn<ParameterInfo> nameColumn = new TextColumn<ParameterInfo>()
		{
			@Override
			public String getValue(ParameterInfo parameter)
			{
				return parameter.getName();
			}
		};
		dataGrid.addColumn(nameColumn, "Name");
		
		TextColumn<ParameterInfo> valueColumn = new TextColumn<ParameterInfo>()
		{
			@Override
			public String getValue(ParameterInfo parameter)
			{
				return parameter.getValue();
			}
		};
		dataGrid.addColumn(valueColumn, "Value");
		
		dataGrid.setRowCount(parameters.size(), true);
		dataGrid.setRowData(parameters);
	}
	
	public void setPresenter(ParametersPresenter presenter)
	{
		this.presenter = presenter;
	}
}