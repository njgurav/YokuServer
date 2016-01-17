package com.yoku.server.framework.alerts.actions;

import com.yoku.server.framework.alerts.events.Event;

public class SMSAction extends AbstractAction {
	
	private static final String SMS = "SMS";

	protected SMSAction(Event event, String... messageParams) {
		super(event, messageParams);
	}

	@Override
	protected void performAlertOperation(String message, String... messageParams) {
		// TODO perform sms operation
		
	}

	@Override
	protected String getActionType() {
		return SMS;
	}

}
