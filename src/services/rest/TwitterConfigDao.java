package services.rest;

import twitter4j.*;
import twitter4j.conf.*;

public class TwitterConfigDao {
	private static Twitter twitterInstance = null;
	static {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		//String user = "john_doe_test0";
		//String password = "password420";
		cb.setDebugEnabled(true)
		  .setOAuthConsumerKey("tQRtvohRMp5swXTZW1LUuxVOM")
		  .setOAuthConsumerSecret("gZ615Fk9jurrcAUnVuV3F43c0Abp4Bn5OTDAhuqNEunfb7oCVn")
		  .setOAuthAccessToken("847496458135678977-vjYIlorYntYii9rXt3b8GP2Q0cZXi4C")
		  .setOAuthAccessTokenSecret("EYh6JmZdanOJJfZOtxQooOoPEYUDruBdNhM76JOrCNXVN");
		  //.setUser(user)
		  //.setPassword(password);
		TwitterFactory tf = new TwitterFactory(cb.build());
		twitterInstance = tf.getInstance();
	}

	public static Twitter getModel() {
		return twitterInstance;
	}
}