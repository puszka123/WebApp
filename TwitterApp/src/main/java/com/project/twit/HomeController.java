package com.project.twit;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	private String pin;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	private void resetParams()
	{
		name = since = until = keyword = null;
		count = 0;
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String oauth(Locale locale, Model model) {
		model.addAttribute("authlink", TwitterConfigDao.getOauthLink());
		return "oauth";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
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
	 public String saveP(@Valid @ModelAttribute("popular")PopularModel inputModel, BindingResult bindingResult){  
			if(bindingResult.hasErrors())
			{
				return "popular";
			}
			name = inputModel.getUsername();
			this.count = inputModel.getCount();
	        return "redirect:/popular";
	    }  
	
	@RequestMapping(value="/saveR",method = RequestMethod.POST) 
	 public String saveR(@Valid @ModelAttribute("recent")RecentModel inputModel, BindingResult bindingResult){  
			if(bindingResult.hasErrors())
			{
				return "recent";
			}
			name = inputModel.getUsername();
			this.count = inputModel.getCount();
	        return "redirect:/recent";
	    }  
	
	@RequestMapping(value="/saveI",method = RequestMethod.POST) 
	 public String saveI(@Valid @ModelAttribute("interval")IntervalModel inputModel, BindingResult bindingResult){  
			if(bindingResult.hasErrors())
			{
				return "interval";
			}
			name = inputModel.getUsername();
			this.count = inputModel.getCount();
			this.since = inputModel.getSince();
			this.until = inputModel.getUntil();
	        return "redirect:/interval";
	    } 
	
	@RequestMapping(value="/saveK",method = RequestMethod.POST) 
	 public String saveK(@Valid @ModelAttribute("keyword")KeywordModel inputModel, BindingResult bindingResult){  
			if(bindingResult.hasErrors())
			{
				return "keyword";
			}
			
			name = inputModel.getUsername();
			this.count = inputModel.getCount();
			this.keyword =inputModel.getKeyword();
	        return "redirect:/keyword";
	    } 
	
	@RequestMapping(value="/submitPin",method = RequestMethod.POST) 
	 public String submitPin(@RequestParam("pin") String pin){  
			this.pin = pin;
			TwitterConfigDao.authorizeOauth(pin);
	        return "home";
	    } 
	
	 
	 	@RequestMapping(value = "/popular", method = RequestMethod.GET)
		public String popular(Model model) {
		 	List<Tweet> tweets = TweetsResource.gerPopularUserTweets(name, count);
		 	model.addAttribute("popular", new PopularModel());
			model.addAttribute("tweets", tweets );
			resetParams();
			return "popular";
		}
	 	
	 	@RequestMapping(value = "/recent", method = RequestMethod.GET)
		public String recent(Model model) {
		 	List<Tweet> tweets = TweetsResource.getUserTweetsInInterval(name, count);
		 	model.addAttribute("recent", new RecentModel());
			model.addAttribute("tweets", tweets );
			resetParams();
			return "recent";
		}
	 	
	 	@RequestMapping(value = "/interval", method = RequestMethod.GET)
		public String interval(Model model) {
	 		List<Tweet> tweets = TweetsResource.getUserTweetsInInterval(name, since, until, count);
	 		model.addAttribute("interval", new IntervalModel());
			model.addAttribute("tweets", tweets );
			resetParams();
			return "interval";
		}
	 	
	 	@RequestMapping(value = "/keyword" ,method = RequestMethod.GET)
		public String keyword(Model model) {
	 		List<Tweet> tweets = TweetsResource.getUserTweetsByKeyword(name, count, keyword);
	 		model.addAttribute("keyword", new KeywordModel());
			model.addAttribute("tweets", tweets );
			resetParams();
			return "keyword";
		}
	 	

		
	
}
