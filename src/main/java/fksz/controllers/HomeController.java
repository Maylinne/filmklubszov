package fksz.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fksz.authentication.service.AuthenticationService;
import fksz.authentication.view.controller.LoginFormController;
import fksz.authentication.view.model.LoginRequest;
import fksz.home.view.model.HomepageModel;
import fksz.home.view.model.LanguageUrlMapping;
import fksz.home.view.support.LocalizationUrlBuilder;
import fksz.i18n.service.LocalizationService;

@Controller
@RequestMapping("/")
public class HomeController extends MasterController{
	
	
	public HomeController(LocalizationService localizationService, AuthenticationService authenticationService, LocalizationUrlBuilder localizationUrlBuilder) {
		super(localizationService, authenticationService, localizationUrlBuilder);
	}
	
	@ModelAttribute("homepageModel")
	public HomepageModel homepageModel() {
		HomepageModel result = new HomepageModel();
		result.setLanguageSelectors(getLanguageSelectors());
		if (authenticationService.isUserAuthenticated()) {
			result.setLogoutUrl("/j_spring_security_logout");
			if (authenticationService.isUserAdmin()) {
				result.setAdminUrl(AdminController.REQUEST_MAPPING);
			}
		} else {
			result.setLoginUrl(LoginFormController.REQUEST_MAPPING);
		}
		return result;
	}
	
	@ModelAttribute("loginRequest")
	public LoginRequest createLoginRequest() {
		return new LoginRequest();
	}

	private List<LanguageUrlMapping> getLanguageSelectors() {
		return localizationUrlBuilder.buildAccessibleLanguageSelectors(localizationService.getAccessibleLanguages());
	}

	@RequestMapping(method=RequestMethod.GET)
	public String example(@ModelAttribute("loginRequest") LoginRequest loginRequest, BindingResult bindingResult, HttpSession httpSession) {
		AuthenticationService.isLoginOk(bindingResult, httpSession);
		return "index";
	}


}
