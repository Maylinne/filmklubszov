package fksz.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fksz.authentication.service.AuthenticationService;
import fksz.authentication.view.model.LoginRequest;
import fksz.home.view.support.LocalizationUrlBuilder;
import fksz.i18n.service.LocalizationService;
import fksz.models.UserModel;
import fksz.requests.ChangePswRequest;
import fksz.service.UserService;
import fksz.transformers.UserTransformer;

@Controller
@RequestMapping("/profile")
public class ProfileController extends MasterController{

	@Autowired UserService userService;
	@Autowired UserTransformer userTransformer;
	
	public ProfileController(LocalizationService localizationService, AuthenticationService authenticationService, LocalizationUrlBuilder localizationUrlBuilder) {
		super(localizationService, authenticationService, localizationUrlBuilder);
	}
	
	
	@ModelAttribute("user")
	public UserModel user() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserModel user = new UserModel();
		if (authentication != null) {
			user = userTransformer.dtoToModel(userService.getByName(authentication.getName()));
		}		
		return user;
	}
	
	@ModelAttribute("changePswRequest")
	public ChangePswRequest changePswRequest() {
		return new ChangePswRequest();
	}
	
	@RequestMapping(value="/changepsw", method=RequestMethod.POST)
	public ModelAndView changePsw(ChangePswRequest changePswRequest, BindingResult bindingResult, ModelMap model) {
		String checkString = userService.changeUserPassword(changePswRequest);
		ModelAndView mav = new ModelAndView("profile");
		if(checkString.equals("A jelszó megváltozott.")) {
			mav.addObject("successMsg", checkString);
		}else {
			mav.addObject("errorMsg", checkString);
		}
		
		return mav;
	}

	@RequestMapping(method=RequestMethod.GET)
	public String profile(@ModelAttribute("loginRequest") LoginRequest loginRequest, BindingResult bindingResult, HttpSession httpSession) {
		authenticationService.isLoginOk(bindingResult, httpSession);
		return "profile";
	}

}