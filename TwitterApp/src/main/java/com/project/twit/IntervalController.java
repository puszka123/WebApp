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
public class IntervalController {
	
	private String name;
	private int count;
	private String since;
	private String until;

	private void resetParams()
	{
		name = since = until = null;
		count = 0;
	}
	
	@RequestMapping(value="/saveI",method = RequestMethod.POST) 
	public String saveI(@Valid @ModelAttribute("interval")IntervalModel inputModel, BindingResult bindingResult)
	{  
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
	
	@RequestMapping(value = "/interval", method = RequestMethod.GET)
	public String interval(Model model) 
	 {
	 	List<Tweet> tweets = TweetsResource.getUserTweetsInInterval(name, since, until, count);
	 	model.addAttribute("interval", new IntervalModel());
		model.addAttribute("tweets", tweets );
		resetParams();
		return "interval";
	}
}
