package org.nycteascandiaca.prototypes.web.presentation.client.parameters;

import org.nycteascandiaca.prototypes.web.presentation.client.ClientFactory;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class ParametersActivity extends AbstractActivity implements ParametersPresenter
{
	private ClientFactory clientFactory;

	public ParametersActivity(ClientFactory clientFactory)
	{
		this.clientFactory = clientFactory;
    }

	@Override
	public void start(AcceptsOneWidget container, EventBus eventBus)
	{
		final ParametersView view = clientFactory.getParametersView();
		view.setPresenter(this);
		container.setWidget(view.asWidget());
	}

	@Override
	public void goTo(Place place)
	{
		clientFactory.getPlaceController().goTo(place);
	}

}