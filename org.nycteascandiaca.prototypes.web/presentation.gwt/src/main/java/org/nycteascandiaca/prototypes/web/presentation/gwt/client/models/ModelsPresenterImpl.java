package org.nycteascandiaca.prototypes.web.presentation.gwt.client.models;

import java.util.ArrayList;
import java.util.List;

import org.nycteascandiaca.prototypes.web.domain.Model;
import org.nycteascandiaca.prototypes.web.presentation.gwt.client.ClientFactory;
import org.nycteascandiaca.prototypes.web.presentation.gwt.client.HistoryToken;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class ModelsPresenterImpl extends AbstractActivity implements ModelsPresenter
{
	private ClientFactory clientFactory;
	
	private ModelsView view;

	public ModelsPresenterImpl(ClientFactory clientFactory)
	{
		this.clientFactory = clientFactory;
    }

	@Override
	public void start(AcceptsOneWidget container, EventBus eventBus)
	{
		view = clientFactory.getModelView();
		view.setPresenter(this);
		container.setWidget(view.asWidget());
		
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, "http://localhost:9002/models");
		try
		{
			Request request = builder.sendRequest(null, new RequestCallback()
			{
				public void onError(Request request, Throwable exception)
				{
					Window.alert("Couldn't retrieve JSON");
				}

				public void onResponseReceived(Request request, Response response)
				{
					if (200 == response.getStatusCode())
					{
						String text = response.getText();
						Window.alert(text);
					}
					else
					{
						Window.alert("Couldn't retrieve JSON (" + response.getStatusText() + ")");
					}
				}
			});
		}
		catch (RequestException e)
		{
			Window.alert("Couldn't retrieve JSON");
		}
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
		List<Model> selectedData = view.getSelectedData();
		if (selectedData.size() == 1)
		{
			Model model = selectedData.iterator().next();
			
			StringBuffer sb = new StringBuffer();
			sb.append("model=");
			sb.append(model.getId());
			
			History.newItem(HistoryToken.PARAMETERS.getToken() + sb.toString(), false);
		}
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
