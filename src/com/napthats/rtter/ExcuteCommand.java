package com.napthats.rtter;

import java.util.List;


public class ExcuteCommand {
	private static final ExcuteCommand INSTANCE = new ExcuteCommand();
	private static final ConnectTwitter itsCT = ConnectTwitter.getInstance();
	
	private ExcuteCommand(){

	}
	
	public static ExcuteCommand getInstance() {return INSTANCE;}
	
	//dummy
	public List<String> getTweets() {
		return itsCT.getTweets();
	}

}
