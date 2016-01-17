package com.yoku.server.infra.utils;

public final class Utility {

	
	public static boolean isNullOrBlank(String param) {
		
		boolean isNullOrBlank = false;
		if(param==null || param.length()==0){
			isNullOrBlank = true;
		}
		return isNullOrBlank;
	}
}
