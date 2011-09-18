package com.napthats.rtter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

import twitter4j.*;
import twitter4j.auth.*;




public class ConnectTwitter {
	private static final ConnectTwitter INSTANCE = new ConnectTwitter();
	private final Properties prop = new Properties();
	private final Twitter twitter;

	public static ConnectTwitter getInstance() {
		return INSTANCE;
	}
	
	private ConnectTwitter() {
		try {
			FileInputStream in = new FileInputStream("oauth.properties");
			prop.load(in);
		} catch (IOException e) {
			System.err.println("cannot read oauth.properties."+e);
		}
		
		TwitterFactory factory = new TwitterFactory();
		AccessToken accessToken = new AccessToken(prop.getProperty("token"), prop.getProperty("tokenSecret"));
		twitter = factory.getInstance(accessToken);
	}

	
	public List<String> getTweets() {
		List<Status> statusList = null;
		try {
			statusList = twitter.getUserTimeline();
		}
		catch (TwitterException te) {
			System.err.println("cannot connect twitter." + te);
		}

	    List<String> statusArr = new ArrayList<String>();

	    for (int i = 0; i < statusList.size(); i++) {
	      Date tweetDate = statusList.get(i).getCreatedAt();
	      SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yy HH:mm");
	      statusArr.add(formatter.format(tweetDate) + "-" + statusList.get(i).getText()); 
	    }
	    
	    return statusArr;
	}

	
}
