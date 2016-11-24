package com.osm.controllers.index;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.osm.controllers.iofunc.Common;
import com.osm.persistences.User;

@Controller
public class Home{
	
	@SuppressWarnings("unused")
	private Logger logger=Logger.getLogger(Home.class);

	@Autowired
	private Common common;
	
	 @RequestMapping(value="/",method=RequestMethod.GET)
	 public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws AddressException, MessagingException
	 {
		
		 ModelAndView  model = new ModelAndView("home");
		 User user = null;
		 user = common.getSaveUser(request);
		 
		 if(user != null){
			 request.setAttribute("user", user);
			 model.addObject("user",user);
		 }else{
			 model.addObject("user",null);
		 }
		 return model;
	 }
	 
	 @RequestMapping(value="login",method=RequestMethod.GET)
	 public ModelAndView loginregister()
	 {
		 //System.out.println("Generated code => "+common.codeGenerate());
		 return new ModelAndView("login_register");
	 }
	 
	 @RequestMapping(value="myaccount",method=RequestMethod.GET)
	 public ModelAndView myaccount()
	 {
		 return new ModelAndView("my_account");
	 }
}
