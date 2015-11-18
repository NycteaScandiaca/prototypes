package org.nycteascandiaca.prototypes.web.presentation.client.model;

import org.nycteascandiaca.prototypes.web.presentation.client.ClientFactory;
import org.nycteascandiaca.prototypes.web.presentation.client.HistoryToken;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class ModelActivity extends AbstractActivity implements ModelPresenter
{
	private ClientFactory clientFactory;

	public ModelActivity(ClientFactory clientFactory)
	{
		this.clientFactory = clientFactory;
    }

	@Override
	public void start(AcceptsOneWidget container, EventBus eventBus)
	{
		final ModelView view = clientFactory.getModelView();
		view.setPresenter(this);
		container.setWidget(view.asWidget());
	}

	@Override
	public void goTo(Place place)
	{
		clientFactory.getPlaceController().goTo(place);
	}

	@Override
	public void onApplyButtonClick()
	{
		History.newItem(HistoryToken.PARAMETERS.getToken());
	}
}
