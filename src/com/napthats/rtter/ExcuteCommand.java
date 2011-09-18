package com.napthats.rtter;

public class ExcuteCommand {
	private static final ExcuteCommand INSTANCE = new ExcuteCommand();
	
	private ExcuteCommand(){		
	}
	
	public static ExcuteCommand getInstance() {return INSTANCE;}
	
	//dummy
	public String getTweets() {
		return "dummy";
	}

}
