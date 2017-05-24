package com.project.twit;


import java.util.ArrayList;
import java.util.List;

import com.project.model.Tweet;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;


public class TweetsResource {


	public static List<Tweet> getUserTweetsInInterval(String user, String since, String until, int count)
	{
		List<Tweet> tweets = new ArrayList<Tweet>();

		Twitter twitter = TwitterConfigDao.getModel();
	    Query query = new Query("from:" + user);
	    query.since(since);
	    query.until(until);
	    query.setResultType(Query.RECENT);
	    query.setCount(count);
	    QueryResult result = null;
		try {
			result = twitter.search(query);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i = 0;
	    for (Status status : result.getTweets()){
	    	Tweet tweet = new Tweet(Integer.toString(i), status.getUser().getScreenName(), status.getUser().getCreatedAt(), status.getText());
	    	tweets.add(tweet);
	    	i++;
	    }
	    
	    return tweets;
	}

	public static List<Tweet> getUserTweetsInInterval(String user, int count) {
		List<Tweet> tweets = new ArrayList<Tweet>();

		Twitter twitter = TwitterConfigDao.getModel();
	    Query query = new Query("from:" + user);
	    query.setResultType(Query.RECENT);
	    query.setCount(count);
	    QueryResult result = null;
		try {
			result = twitter.search(query);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i = 0;
	    for (Status status : result.getTweets()){
	    	Tweet tweet = new Tweet(Integer.toString(i), status.getUser().getScreenName(), status.getUser().getCreatedAt(), status.getText());
	    	tweets.add(tweet);
	    	i++;
	    }
	    
	    return tweets;
	}
	

	public static List<Tweet> gerPopularUserTweets(String user, int count) {
		List<Tweet> tweets = new ArrayList<Tweet>();

		Twitter twitter = TwitterConfigDao.getModel();
	    Query query = new Query("from:" + user);
	    query.setResultType(Query.POPULAR);
	    query.setCount(count);
	    QueryResult result = null;
		try {
			result = twitter.search(query);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i = 0;
	    for (Status status : result.getTweets()){
	    	Tweet tweet = new Tweet(Integer.toString(i), status.getUser().getScreenName(), status.getUser().getCreatedAt(), status.getText());
	    	tweets.add(tweet);
	    	i++;
	    }
	    
	    return tweets;
	}
	
	/*@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("timeline")
	public List<Tweet> getUserTimeline() {
		List<Tweet> tweets = new ArrayList<Tweet>();

		int i = 0;
		Twitter twitter = TwitterConfigDao.getModel();
	    List<Status> statuses = null;
		try {
			statuses = twitter.getHomeTimeline();
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    for (Status status : statuses) {
	        System.out.println(status.getUser().getName() + ":" +
	                           status.getText());
	        
	    	Tweet tweet = new Tweet(Integer.toString(i), status.getUser().getScreenName(), status.getUser().getCreatedAt(), status.getText());
	    	tweets.add(tweet);
	    	i++;
	    }
		
	    
	    return tweets;
	}*/
	

	public static List<Tweet> getUserTweetsByKeyword(String user, int count, String keyword) {
		List<Tweet> tweets = new ArrayList<Tweet>();

		Twitter twitter = TwitterConfigDao.getModel();
	    Query query = new Query("from:" + user + " " + keyword);
	    query.setResultType(Query.RECENT);
	    query.setCount(count);
	    QueryResult result = null;
		try {
			result = twitter.search(query);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i = 0;
	    for (Status status : result.getTweets()){
	    	Tweet tweet = new Tweet(Integer.toString(i), status.getUser().getScreenName(), status.getUser().getCreatedAt(), status.getText());
	    	tweets.add(tweet);
	    	i++;
	    }
	    
	    return tweets;
	}
	
}
