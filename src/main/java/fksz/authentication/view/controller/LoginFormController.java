package fksz.authentication.view.controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import fksz.authentication.service.AuthenticationService;
import fksz.authentication.view.model.LoginRequest;
import fksz.controllers.MasterController;
import fksz.home.view.support.LocalizationUrlBuilder;
import fksz.i18n.service.LocalizationService;

@Controller
public class LoginFormController extends MasterController {
	public static final String REQUEST_MAPPING = "/login.html";

	public LoginFormController(LocalizationService localizationService, AuthenticationService authenticationService, LocalizationUrlBuilder localizationUrlBuilder) {
		super(localizationService, authenticationService, localizationUrlBuilder);
	}

	@RequestMapping(REQUEST_MAPPING)
	public String showLogin(@ModelAttribute("loginRequest") LoginRequest loginRequest, BindingResult bindingResult, HttpSession httpSession) {
		Throwable authException = (Throwable) httpSession.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		if (authException != null) {
			bindingResult.reject(authException.getMessage(), authException.getMessage());
			httpSession.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		}
		return "login_form";
	}
}
