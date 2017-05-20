package services.rest;

import twitter4j.*;
import twitter4j.conf.*;


public class TwitterAccessExample {
	public static void main(String args[]) {
		
		System.out.println("hello");
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		  .setOAuthConsumerKey("tQRtvohRMp5swXTZW1LUuxVOM")
		  .setOAuthConsumerSecret("gZ615Fk9jurrcAUnVuV3F43c0Abp4Bn5OTDAhuqNEunfb7oCVn")
		  .setOAuthAccessToken("847496458135678977-vjYIlorYntYii9rXt3b8GP2Q0cZXi4C")
		  .setOAuthAccessTokenSecret("EYh6JmZdanOJJfZOtxQooOoPEYUDruBdNhM76JOrCNXVN");
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		
	    // The factory instance is re-useable and thread safe.
	    Query query = new Query("from:uzytkownik321 cos");
	    QueryResult result = null;
		try {
			result = twitter.search(query);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    for (Status status : result.getTweets()){
	    	System.out.println(status.getCreatedAt());
	    	System.out.println(status.getUser());

	        System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
	    }
	}

}
