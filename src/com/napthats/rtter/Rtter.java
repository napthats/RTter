package com.napthats.rtter;

public class RTter implements showTweetsMediator {
	private MainWindow itsWindow;
	private final ExcuteCommand itsEC = ExcuteCommand.getInstance();
	
	public static void main(String[] args) {
		RTter myRTer = new RTter();
		myRTer.start();
	}
	
	public void start() {
		itsWindow = MainWindow.getInstance(this);
	}
	
	public void showTweets() {
		itsWindow.displayTweets(itsEC.getTweets());
	}
}
