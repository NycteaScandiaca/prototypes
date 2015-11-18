package org.nycteascandiaca.prototypes.web.presentation.client.commands;

import org.nycteascandiaca.prototypes.web.presentation.client.HistoryToken;

import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.user.client.History;

public class MenuCommand implements ScheduledCommand
{
	private final HistoryToken historyToken;
	
	public MenuCommand(HistoryToken historyToken)
	{
		this.historyToken = historyToken;
	}

	@Override
	public void execute()
	{
		History.newItem(historyToken.getToken());
	}

}
