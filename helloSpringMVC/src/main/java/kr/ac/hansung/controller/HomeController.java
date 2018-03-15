package kr.ac.hansung.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller // @Component(bean) + 컨트롤러 역할
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	// private static final Logger logger = LoggerFactory.getLogger(kr.ac.hansung.controller.HomeController);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showHome(HttpServletRequest request, Locale locale, Model model) {

		logger.info("info level: Welcome home! The client locale is {}", locale);
		
		String url = request.getRequestURI().toString();
		String clientIPaddress = request.getRemoteAddr();
		
		logger.info("Request URL: " + url);
		logger.info("Client IP: " + clientIPaddress);
		
		return "home";
	}

}
