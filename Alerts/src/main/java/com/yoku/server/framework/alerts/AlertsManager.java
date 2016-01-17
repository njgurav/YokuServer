package com.yoku.server.framework.alerts;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import com.yoku.server.framework.alerts.actions.AbstractAction;
import com.yoku.server.framework.alerts.actions.ActionFactory;
import com.yoku.server.framework.alerts.events.Event;
import com.yoku.server.infra.dtos.UserContext;
import com.yoku.server.infra.utils.Utility;

public final class AlertsManager {

	private AlertsManager(){
		
	}
	
	/**
	 * @return
	 */
	public static AlertsManager getInstance() {
		return new AlertsManager();
	}
	
	/**
	 * 
	 * @param userContext 	The {@link UserContext}.
	 * @param event			The {@link Event} for which the alert needs to be generated
	 * @param messageParams		The params to be added in the alert message
	 */
	public void alert(UserContext userContext, Event event, String... messageParams){
		//Fetch Actions pertaining to the particular user for the given Event.
		String actions = "SMS,EMAIL";
		AbstractAction action = prepareActionQueue(fetchActionTypes(actions), event, messageParams);
		action.alert();
	}
	
	private AbstractAction prepareActionQueue(Queue<String> actionQueue, Event event, String... messageParams){

		AbstractAction action = null;
		if(actionQueue!=null){
			String actionString = actionQueue.poll();
			if(!Utility.isNullOrBlank(actionString)){
				action = ActionFactory.fromString(actionString).getAction(event, messageParams);
				action.setNextAction(prepareActionQueue(actionQueue, event, messageParams));
			}
		}
		return action;
	}
	
	private Queue<String> fetchActionTypes(String actions){
		return actions != null ? new LinkedList<String>(Arrays.asList(actions.trim().split(","))) : null;
	}
	
}
