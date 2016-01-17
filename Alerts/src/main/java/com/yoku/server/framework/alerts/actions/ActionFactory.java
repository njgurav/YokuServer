package com.yoku.server.framework.alerts.actions;

import java.util.HashMap;
import java.util.Map;

import com.yoku.server.framework.alerts.events.Event;

public enum ActionFactory {
	
	SMS ("SMS"){
		@Override
		public AbstractAction getAction(Event event, String... messageParams){
			return new SMSAction(event, messageParams);
		};
	},
	EMAIL ("EMAIL"){
		@Override
		public AbstractAction getAction(Event event, String... messageParams){
			return new EmailAction(event, messageParams);
		};
	};
	
	private String name;
	
	private static final Map<String, ActionFactory> stringMap = new HashMap<String, ActionFactory>();
      
	  static
	  {
	    for(ActionFactory dist : values())
	        stringMap.put(dist.toString(), dist);
	  }
	
	private ActionFactory(String name){
		this.name = name;
	}
	
	public String toString(){
		return this.name;
	}
	
	public static ActionFactory fromString(String string){
		return stringMap.get(string);
	}
	
	public abstract AbstractAction getAction(Event event, String... messageParams);

}
