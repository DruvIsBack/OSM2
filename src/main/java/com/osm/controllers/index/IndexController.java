package com.osm.controllers.index;

import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.osm.controllers.iofunc.Common;
import com.osm.persistences.EmailVerification;
import com.osm.persistences.User;
import com.osm.services.EmailVerificationService;
import com.osm.services.UserService;


@Controller
public class IndexController{
	
	@SuppressWarnings("unused")
	private Logger logger=Logger.getLogger(IndexController.class);

	@Autowired
	private UserService userservice;
	
	@Autowired
	private EmailVerificationService evService;
	
	@Autowired
	private Common common;
	
	 @RequestMapping(value="/",method=RequestMethod.GET)
	 public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws AddressException, MessagingException
	 {
/*//Try to create file
		 	ObjectMapper mapper = new ObjectMapper();
		 	try {
		 		TestAnimal cat = new TestAnimal(1,"cat"); 
		 		ServletContext ctx = request.getServletContext();
		 		String path = ctx.getRealPath("/animal.json");
		 		//FileWriter fw = new FileWriter(path);
				// Convert object to JSON string and save into a file directly
				mapper.writeValue(new File(path), cat);
				String jsonInString = mapper.writeValueAsString(cat);
				System.out.println(jsonInString);
				jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cat);
				System.out.println(jsonInString);
				

			} catch (JsonGenerationException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
//Try to create file
*/		 ModelAndView  model = new ModelAndView("home");
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
	 
	 @RequestMapping(value="emailverify",method=RequestMethod.GET)
	 public ModelAndView emailverify(@RequestParam("verifycode") String code,@RequestParam String username){
		 ModelAndView model = new ModelAndView("email_verify");
		 User user = userservice.getUserByUsername(username);
		 EmailVerification ev = evService.getEV(user);
		 if (ev != null && ev.getCode().equals(code)){
			 System.out.println("Code Matched...");
			 model.addObject("match", false);
			 if(userservice.setVerifyToUser(user)){
				 if(evService.deleteEV(ev)){ 
					 model.addObject("match", true);
				 }
			 }else{
				 System.out.println("Error occured when trying userservice.setVerifyToUser(user)");
			 }
		 }else{
			 System.out.println("Code not matched...");
		 }
		 return model;
	 }
}
