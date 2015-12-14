package org.nycteascandiaca.prototypes.web.presentation.gwt.client.models;

import java.util.Collections;
import java.util.List;

import org.nycteascandiaca.prototypes.web.domain.Model;

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
import com.google.gwt.view.client.SingleSelectionModel;

public class ModelsViewImpl extends Composite implements ModelsView
{	
	@UiTemplate("ModelsView.ui.xml")
	interface HomeViewUiBinder extends UiBinder<Widget, ModelsViewImpl>
	{
		
	}
	
	private static HomeViewUiBinder uiBinder = GWT.create(HomeViewUiBinder.class);
	
	@UiField
	DataGrid<Model> dataGrid;
	
	private SingleSelectionModel<Model> selectionModel;
		
	@UiField
	PushButton createNewButton;
	
	@UiField
	PushButton editButton;
	
	@UiField
	PushButton deleteButton;
	
	private ModelsPresenter presenter;

	public ModelsViewImpl()
	{
		initWidget(uiBinder.createAndBindUi(this));
		
		initializeDataGrid();
	}
	
	private void initializeDataGrid()
	{
		TextColumn<Model> idColumn = new TextColumn<Model>()
		{
			@Override
			public String getValue(Model parameter)
			{
				return Long.toString(parameter.getId());
			}
		};
		dataGrid.addColumn(idColumn, "Id");
		
		TextColumn<Model> nameColumn = new TextColumn<Model>()
		{
			@Override
			public String getValue(Model parameter)
			{
				return parameter.getName();
			}
		};
		dataGrid.addColumn(nameColumn, "Name");
		
		selectionModel = new SingleSelectionModel<Model>();
		dataGrid.setSelectionModel(selectionModel);
	}
	
	@Override
	public void setPresenter(ModelsPresenter presenter)
	{
		this.presenter = presenter;
	}
	
	@UiHandler("editButton")
	void onEditButtonClick(ClickEvent event)
	{
		if (presenter != null)
		{
			presenter.onEditButtonClick();
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
	
	@UiHandler("createNewButton")
	void onCreateNewButtonClick(ClickEvent event)
	{
		if (presenter != null)
		{
			presenter.onCreateNewButtonClick();
		}
	}
	
	@Override
	public void setData(List<Model> data)
	{
		dataGrid.setRowCount(data.size(), true);
		dataGrid.setRowData(data);
	}

	@Override
	public List<Model> getSelectedData()
	{
		Model selectedObject = selectionModel.getSelectedObject();
		if (selectedObject == null)
		{
			return Collections.emptyList();
		}
		return Collections.singletonList(selectedObject);
	}
}
