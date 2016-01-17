package com.yoku.server.framework.alerts.actions;

import com.yoku.server.framework.alerts.events.Event;

public class NoAction extends AbstractAction {

	protected NoAction(Event event, String[] messageParams) {
		super(event, messageParams);
	}

	@Override
	protected String getActionType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void performAlertOperation(String message, String... messageParams) {
		
	}

}
