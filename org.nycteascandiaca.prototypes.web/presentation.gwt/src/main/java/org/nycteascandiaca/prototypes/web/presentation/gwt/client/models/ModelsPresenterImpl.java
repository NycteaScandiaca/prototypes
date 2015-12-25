package org.nycteascandiaca.prototypes.web.presentation.gwt.client.models;

import java.util.ArrayList;
import java.util.List;

import org.nycteascandiaca.prototypes.web.domain.Model;
import org.nycteascandiaca.prototypes.web.presentation.gwt.client.ClientFactory;
import org.nycteascandiaca.prototypes.web.presentation.gwt.client.HistoryToken;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.jsonp.client.JsonpRequestBuilder;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class ModelsPresenterImpl extends AbstractActivity implements ModelsPresenter
{
	private final ModelsPlace place;
	
	private final ClientFactory clientFactory;
	
	private ModelsView view;

	public ModelsPresenterImpl(ModelsPlace place, ClientFactory clientFactory)
	{
		this.place = place;
		this.clientFactory = clientFactory;
    }

	@Override
	public void start(AcceptsOneWidget container, EventBus eventBus)
	{
		view = clientFactory.getModelView();
		view.setPresenter(this);
		container.setWidget(view.asWidget());
		
		loadData();
	}
	
	private void loadData()
	{
			
		
		/*RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, "http://localhost:9002/models");
		try
		{
			builder.sendRequest(null, new RequestCallback()
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
		}*/
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
			
			History.newItem(HistoryToken.PARAMETERS.getToken() + sb.toString());
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
