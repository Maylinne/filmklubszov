package fksz.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fksz.authentication.service.AuthenticationService;
import fksz.authentication.view.model.LoginRequest;
import fksz.home.view.support.LocalizationUrlBuilder;
import fksz.i18n.service.LocalizationService;

@Controller
@RequestMapping("/common_error")
public class ErrorController extends MasterController{

	public ErrorController(LocalizationService localizationService, AuthenticationService authenticationService, LocalizationUrlBuilder localizationUrlBuilder) {
		super(localizationService, authenticationService, localizationUrlBuilder);
	}

	@RequestMapping(method=RequestMethod.GET)
	public String error(@ModelAttribute("loginRequest") LoginRequest loginRequest, BindingResult bindingResult, HttpSession httpSession) {
		authenticationService.isLoginOk(bindingResult, httpSession);
		return "common_error";
	}

}
