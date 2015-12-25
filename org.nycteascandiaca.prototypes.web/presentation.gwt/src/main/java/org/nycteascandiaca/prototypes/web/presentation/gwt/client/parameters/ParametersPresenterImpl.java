package org.nycteascandiaca.prototypes.web.presentation.gwt.client.parameters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.nycteascandiaca.prototypes.web.domain.Parameter;
import org.nycteascandiaca.prototypes.web.presentation.gwt.client.ClientFactory;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class ParametersPresenterImpl extends AbstractActivity implements ParametersPresenter
{
	private final ParametersPlace place;
	
	private final ClientFactory clientFactory;
	
	private ParametersView view;

	public ParametersPresenterImpl(ParametersPlace place, ClientFactory clientFactory)
	{
		this.place = place;
		this.clientFactory = clientFactory;
    }

	@Override
	public void start(AcceptsOneWidget container, EventBus eventBus)
	{
		view = clientFactory.getParametersView();
		view.setPresenter(this);
		container.setWidget(view.asWidget());
		
		loadData();
	}

	private void loadData()
	{
		if (place.getModelId() == null)
		{
			view.setData(Collections.<Parameter>emptyList());
			return;
		}
		
		List<Parameter> parameters = new ArrayList<Parameter>();
		for (int i = 0; i < place.getModelId(); i++)
		{
			Parameter parameter = new Parameter();
			parameter.setId(Long.valueOf(i));
			parameter.setName("Name " + i);
			parameter.setValue("Value " + i);
			parameters.add(parameter);
		}
		
		view.setData(parameters);
	}

	@Override
	public void goTo(Place place)
	{
		clientFactory.getPlaceController().goTo(place);
	}

	@Override
	public void onGenerateButtonClick()
	{
		
	}

	@Override
	public void onDeleteButtonClick()
	{
		
	}

	@Override
	public void onCreateNewButtonClick()
	{
		List<Parameter> parameters = new ArrayList<Parameter>();
		for (int i = 0; i < 1000; i++)
		{
			Parameter parameter = new Parameter();
			parameter.setId(Long.valueOf(i));
			parameter.setName("Name " + i);
			parameter.setValue("Value " + i);
			parameters.add(parameter);
		}
		
		view.setData(parameters);
	}

}