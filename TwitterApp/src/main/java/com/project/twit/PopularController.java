package com.project.twit;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.project.model.*;


@Controller
public class PopularController {
	
	private String name;
	private int count;

	private void resetParams()
	{
		name = null;
		count = 0;
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
	
		@RequestMapping(value = "/popular", method = RequestMethod.GET)
		public String popular(Model model) {
		 	List<Tweet> tweets = TweetsResource.gerPopularUserTweets(name, count);
		 	model.addAttribute("popular", new PopularModel());
			model.addAttribute("tweets", tweets );
			resetParams();
			return "popular";
		}

}