package services.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import services.rest.model.Tweet;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

@Path("/tweets")
public class TweetsResource {
	@Context
	UriInfo uriInfo;

	@Context
	Request request;
	

	
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("interval/{user}+{since}+{until}+{count}")
	public List<Tweet> getUserTweetsInInterval(@PathParam("user") String user, @PathParam("since") String since, @PathParam("until") String until, @PathParam("count") String count) {
		List<Tweet> tweets = new ArrayList<Tweet>();

		Twitter twitter = TwitterConfigDao.getModel();
	    Query query = new Query("from:" + user);
	    query.since(since);
	    query.until(until);
	    query.setResultType(Query.RECENT);
	    query.setCount(Integer.parseInt(count));
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
	
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("recent/{user}+{count}")
	public List<Tweet> getUserTweetsInInterval(@PathParam("user") String user, @PathParam("count") String count) {
		List<Tweet> tweets = new ArrayList<Tweet>();

		Twitter twitter = TwitterConfigDao.getModel();
	    Query query = new Query("from:" + user);
	    query.setResultType(Query.RECENT);
	    query.setCount(Integer.parseInt(count));
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
	
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("popular/{user}+{count}")
	public List<Tweet> gerPopularUserTweets(@PathParam("user") String user, @PathParam("count") String count) {
		List<Tweet> tweets = new ArrayList<Tweet>();

		Twitter twitter = TwitterConfigDao.getModel();
	    Query query = new Query("from:" + user);
	    query.setResultType(Query.POPULAR);
	    query.setCount(Integer.parseInt(count));
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
	
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("keyword/{user}+{keyword}+{count}")
	public List<Tweet> getUserTweetsByKeyword(@PathParam("user") String user, @PathParam("keyword") String keyword, @PathParam("count") String count) {
		List<Tweet> tweets = new ArrayList<Tweet>();

		Twitter twitter = TwitterConfigDao.getModel();
	    Query query = new Query("from:" + user + " " + keyword);
	    query.setResultType(Query.RECENT);
	    query.setCount(Integer.parseInt(count));
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
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void showHelp(@Context HttpServletResponse servletResponse)
			throws IOException {
		servletResponse.sendRedirect("../index.html");
	}
}
