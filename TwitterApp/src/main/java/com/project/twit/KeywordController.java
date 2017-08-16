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
public class KeywordController {
	
	private String name;
	private int count;
	private String keyword;

	private void resetParams()
	{
		name = keyword = null;
		count = 0;
	}
	
	@RequestMapping(value="/saveK",method = RequestMethod.POST) 
	public String saveK(@Valid @ModelAttribute("keyword")KeywordModel inputModel, BindingResult bindingResult)
	{  
		if(bindingResult.hasErrors())
		{
			return "keyword";
		}
			
		name = inputModel.getUsername();
		this.count = inputModel.getCount();
		this.keyword =inputModel.getKeyword();
	       return "redirect:/keyword";
	} 
	
	@RequestMapping(value = "/keyword" ,method = RequestMethod.GET)
	public String keyword(Model model)
	{
	 	List<Tweet> tweets = TweetsResource.getUserTweetsByKeyword(name, count, keyword);
	 	model.addAttribute("keyword", new KeywordModel());
		model.addAttribute("tweets", tweets );
		resetParams();
		return "keyword";
	}
	 	

		
	
}