package com.yoku.server.framework.alerts.actions;

import com.yoku.server.framework.alerts.events.Event;

public abstract class AbstractAction {

	private AbstractAction actionType;
	
	private Event event;
	
	private String[] messageParams;
	
	/**
	 * 
	 * @param event
	 * @param messageParams
	 */
	protected AbstractAction(Event event, String... messageParams){
		this.event = event;
		this.messageParams = messageParams;
	}
	
	public final void alert(){
		final String message = fetchMessage();
		this.performAlertOperation(message, this.messageParams);
		if(actionType!=null){
			actionType.alert();
		}
	}
	
	/**
	 * Returns the ActionType of the inheriting class, Eg. SMSAction returns "SMS", 
	 * which is used to pull the message from db related to Event.SMS
	 * @return
	 */
	protected abstract String getActionType();
	
	protected abstract void performAlertOperation(String message, String... messageParams);
	
	public void setNextAction(AbstractAction actionType){
		this.actionType = actionType;
	}
	
	private String fetchMessage() {
		
		//Populate message here, fetch from db based on Event.ActionType
		return null;
	}
	
}
