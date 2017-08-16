package com.project.twit;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import twitter4j.TwitterException;


@Controller
public class LoginController 
{
	private String pin;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String oauth(Locale locale, Model model)
	{
		model.addAttribute("authlink", TwitterConfigDao.getOauthLink());
		return "oauth";
	}	
	
	@RequestMapping(value="/submitPin",method = RequestMethod.POST) 
	public String submitPin(@RequestParam("pin") String pin)
	{  
		this.pin = pin;
		try 
		{
			TwitterConfigDao.authorizeOauth(pin);
		} 
		catch (TwitterException e) 
		{
			System.out.println("fail");
			return "redirect:/";
		}
	       return "home";
	 } 
	
	 
}
