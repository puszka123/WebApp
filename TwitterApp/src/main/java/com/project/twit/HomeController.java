package com.project.twit;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.project.model.*;



/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private String name;
	private int count;
	private String since;
	private String until;
	private String keyword;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	private void resetParams()
	{
		name = since = until = keyword = null;
		count = 0;
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact(Locale locale, Model model) {
		return "contact";
	}
	
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about(Locale locale, Model model) {
		return "about";
	}
	
	@RequestMapping(value="/saveP",method = RequestMethod.POST) 
	 public String saveP(@RequestParam("username") String username, @RequestParam("count") String count){  
			//writing to class fields is a bit stupid but i have no idea how to do it better :D
			name = username;
			this.count = Integer.valueOf(count);
	        return "redirect:/popular";
	    }  
	
	@RequestMapping(value="/saveR",method = RequestMethod.POST) 
	 public String saveR(@RequestParam("username") String username, @RequestParam("count") String count){  
			//writing to class fields is a bit stupid but i have no idea how to do it better :D
			name = username;
			this.count = Integer.valueOf(count);
	        return "redirect:/recent";
	    }  
	
	@RequestMapping(value="/saveI",method = RequestMethod.POST) 
	 public String saveI(@RequestParam("username") String username,@RequestParam("since") String since,
			 @RequestParam("until") String until, @RequestParam("count") String count){  
			//writing to class fields is a bit stupid but i have no idea how to do it better :D
			name = username;
			this.count = Integer.valueOf(count);
			this.since = since;
			this.until = until;
	        return "redirect:/interval";
	    } 
	
	@RequestMapping(value="/saveK",method = RequestMethod.POST) 
	 public String saveK(@RequestParam("username") String username, 
			 @RequestParam("count") String count, @RequestParam("keyword") String keyword){  
			//writing to class fields is a bit stupid but i have no idea how to do it better :D
			name = username;
			this.count = Integer.valueOf(count);
			this.keyword = keyword;
	        return "redirect:/keyword";
	    } 
	
	 
	 	@RequestMapping(value = "/popular")
		public String popular(Model model) {
		 	List<Tweet> tweets = TweetsResource.gerPopularUserTweets(name, count);
			model.addAttribute("tweets", tweets );
			resetParams();
			return "popular";
		}
	 	
	 	@RequestMapping(value = "/recent")
		public String recent(Model model) {
		 	List<Tweet> tweets = TweetsResource.getUserTweetsInInterval(name, count);
			model.addAttribute("tweets", tweets );
			resetParams();
			return "recent";
		}
	 	
	 	@RequestMapping(value = "/interval")
		public String interval(Model model) {
	 		List<Tweet> tweets = TweetsResource.getUserTweetsInInterval(name, since, until, count);
			model.addAttribute("tweets", tweets );
			resetParams();
			return "interval";
		}
	 	
	 	@RequestMapping(value = "/keyword")
		public String keyword(Model model) {
	 		List<Tweet> tweets = TweetsResource.getUserTweetsByKeyword(name, count, keyword);
			model.addAttribute("tweets", tweets );
			resetParams();
			return "keyword";
		}
	
}
