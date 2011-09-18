package com.napthats.rtter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConnectTwitter {
	private ConnectTwitter() {
		Properties prop = new Properties();
		try {
			FileInputStream in = new FileInputStream("oauth.properties");
			prop.load(in);
		} catch (IOException e) {
			System.err.println("IO Error."+e);
		}
		
	}

	
}
