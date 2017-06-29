package com.project.twit;

import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.*;

public class TwitterConfigDao {
	private static Twitter twitterInstance = null;
	private static Twitter twitterOauthInstance = null;
	private static RequestToken requestToken = null;
	private static AccessToken accessToken = null;
	private static String token = null;
	private static String tokenSecret = null;
	static {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		//String user = "john_doe_test0";
		//String password = "password420";
		cb.setDebugEnabled(true)
		  .setOAuthConsumerKey("tQRtvohRMp5swXTZW1LUuxVOM")
		  .setOAuthConsumerSecret("gZ615Fk9jurrcAUnVuV3F43c0Abp4Bn5OTDAhuqNEunfb7oCVn")
		  .setOAuthAccessToken("847496458135678977-CeCYDK7pRzG9Mff6bgfYOj4SmO5lNPH")
		  .setOAuthAccessTokenSecret("fo5NTZatsRhj2shrrRn6l6j1DXjVNlHSrQIk0gyiLcP3B");
		  //.setUser(user)
		  //.setPassword(password);
		TwitterFactory tf = new TwitterFactory(cb.build());
		twitterInstance = tf.getInstance();
		
		ConfigurationBuilder cb2 = new ConfigurationBuilder();
		cb2.setDebugEnabled(true)
        .setOAuthConsumerKey("tQRtvohRMp5swXTZW1LUuxVOM")
        .setOAuthConsumerSecret("gZ615Fk9jurrcAUnVuV3F43c0Abp4Bn5OTDAhuqNEunfb7oCVn")
        .setOAuthAccessToken(null)
        .setOAuthAccessTokenSecret(null);
		
		TwitterFactory tf2 = new TwitterFactory(cb2.build());
	    twitterOauthInstance = tf2.getInstance();
		try {
			requestToken = twitterOauthInstance.getOAuthRequestToken();
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Twitter getModel() {
		return twitterInstance;
	}
	
	public static String getOauthLink() {
		return requestToken.getAuthorizationURL();
	}
	
	public static void authorizeOauth(String pin) throws TwitterException {
		try {
			accessToken = twitterOauthInstance.getOAuthAccessToken(requestToken, pin);
			token = accessToken.getToken();
	        tokenSecret = accessToken.getTokenSecret();
		} catch (TwitterException e) {
			throw e;
		} finally {
			ConfigurationBuilder cb2 = new ConfigurationBuilder();
			cb2.setDebugEnabled(true)
	        .setOAuthConsumerKey("tQRtvohRMp5swXTZW1LUuxVOM")
	        .setOAuthConsumerSecret("gZ615Fk9jurrcAUnVuV3F43c0Abp4Bn5OTDAhuqNEunfb7oCVn")
	        .setOAuthAccessToken(null)
	        .setOAuthAccessTokenSecret(null);
			
			TwitterFactory tf2 = new TwitterFactory(cb2.build());
		    twitterOauthInstance = tf2.getInstance();
			try {
				requestToken = twitterOauthInstance.getOAuthRequestToken();
			} catch (TwitterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}