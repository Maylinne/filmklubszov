package fksz.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	@Autowired
	UserService userService;
	@Autowired
	UserTransformer userTransformer;
	
	
	public ProfileController(LocalizationService localizationService, AuthenticationService authenticationService, LocalizationUrlBuilder localizationUrlBuilder) {
		super(localizationService, authenticationService, localizationUrlBuilder);
	}
	
	
	@ModelAttribute("user")
	public UserModel user() {
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		return userTransformer.dtoToModel(userService.getByName(userName));
	}
	
	@ModelAttribute("changePswRequest")
	public ChangePswRequest changePswRequest() {
		return new ChangePswRequest();
	}
	
	@RequestMapping(value="/changepsw", method=RequestMethod.POST)
	public String changePsw(ChangePswRequest changePswRequest, BindingResult bindingResult) {
		userService.changeUserPassword(changePswRequest);
		return "redirect:/profile";
	}

	@RequestMapping(method=RequestMethod.GET)
	public String profile(@ModelAttribute("loginRequest") LoginRequest loginRequest, BindingResult bindingResult, HttpSession httpSession) {
		AuthenticationService.isLoginOk(bindingResult, httpSession);
		return "profile";
	}

}