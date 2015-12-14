package org.nycteascandiaca.prototypes.web.presentation.gwt.client;

import org.nycteascandiaca.prototypes.web.presentation.gwt.client.application.ApplicationView;
import org.nycteascandiaca.prototypes.web.presentation.gwt.client.models.ModelsPlace;
import org.nycteascandiaca.prototypes.web.presentation.gwt.client.mvp.ApplicationActivityMapper;
import org.nycteascandiaca.prototypes.web.presentation.gwt.client.mvp.ApplicationPlaceHistoryMapper;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.web.bindery.event.shared.EventBus;

public class Application implements EntryPoint
{
	private SimplePanel containerWidget;
	
	private ModelsPlace defaultPlace = new ModelsPlace();
	
	@Override
	public void onModuleLoad()
    {        
        ClientFactory clientFactory = GWT.create(ClientFactory.class);
        ApplicationView applicatioView = clientFactory.getApplicationView();
        containerWidget = applicatioView.getApplicationContentHolder();
 
        EventBus eventBus = clientFactory.getEventBus();
        PlaceController placeController = clientFactory.getPlaceController();

        ActivityMapper activityMapper = new ApplicationActivityMapper(clientFactory);
        ActivityManager activityManager = new ActivityManager(activityMapper,  eventBus);
        activityManager.setDisplay(containerWidget);

        ApplicationPlaceHistoryMapper historyMapper = GWT.create(ApplicationPlaceHistoryMapper.class);
        PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
        historyHandler.register(placeController, eventBus, defaultPlace);

        RootLayoutPanel.get().add(applicatioView);

        historyHandler.handleCurrentHistory();
	}
}