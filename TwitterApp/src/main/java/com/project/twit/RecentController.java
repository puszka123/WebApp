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
public class RecentController {
	
	private String name;
	private int count;

	private void resetParams()
	{
		name = null;
		count = 0;
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
	
	 	@RequestMapping(value = "/recent", method = RequestMethod.GET)
		public String recent(Model model) {
		 	List<Tweet> tweets = TweetsResource.getUserTweetsInInterval(name, count);
		 	model.addAttribute("recent", new RecentModel());
			model.addAttribute("tweets", tweets );
			resetParams();
			return "recent";
		}
}
