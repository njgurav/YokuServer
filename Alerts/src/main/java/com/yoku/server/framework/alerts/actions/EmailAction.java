package com.yoku.server.framework.alerts.actions;

import com.yoku.server.framework.alerts.events.Event;

public class EmailAction extends AbstractAction {
	
	private static final String EMAIL = "EMAIL";

	protected EmailAction(Event event, String... messageParams) {
		super(event, messageParams);
	}

	@Override
	protected void performAlertOperation(String message, String... messageParams) {
		// TODO Auto-generated method stub

	}

	@Override
	protected String getActionType() {
		return EMAIL;
	}

}
