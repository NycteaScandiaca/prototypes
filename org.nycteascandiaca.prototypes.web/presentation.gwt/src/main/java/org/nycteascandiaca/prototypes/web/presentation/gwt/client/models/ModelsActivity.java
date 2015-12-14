package org.nycteascandiaca.prototypes.web.presentation.gwt.client.models;

import java.util.ArrayList;
import java.util.List;

import org.nycteascandiaca.prototypes.web.domain.Model;
import org.nycteascandiaca.prototypes.web.presentation.gwt.client.ClientFactory;
import org.nycteascandiaca.prototypes.web.presentation.gwt.client.HistoryToken;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class ModelsActivity extends AbstractActivity implements ModelsPresenter
{
	private ClientFactory clientFactory;
	
	private ModelsView view;

	public ModelsActivity(ClientFactory clientFactory)
	{
		this.clientFactory = clientFactory;
    }

	@Override
	public void start(AcceptsOneWidget container, EventBus eventBus)
	{
		view = clientFactory.getModelView();
		view.setPresenter(this);
		container.setWidget(view.asWidget());
	}
	
	@Override
	public void onStop() {
		view = null;
	}
	
	@Override
	public void onCancel() {
		view = null;
	}

	@Override
	public void goTo(Place place)
	{
		clientFactory.getPlaceController().goTo(place);
	}

	@Override
	public void onEditButtonClick()
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void onDeleteButtonClick() {
		// TODO Auto-generated method stub
	}

	@Override
	public void onCreateNewButtonClick() {
		// TODO Auto-generated method stub
		
		createTestData();
	}
	
	private void createTestData()
	{
		List<Model> models = new ArrayList<Model>();
		for (int i = 0; i < 1000; i++)
		{
			Model parameter = new Model();
			parameter.setId(Long.valueOf(i));
			parameter.setName("Name " + i);
			models.add(parameter);
		}
		
		view.setData(models);
	}
}
