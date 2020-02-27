package fksz.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fksz.authentication.service.AuthenticationService;
import fksz.authentication.view.model.LoginRequest;
import fksz.domain.Constants;
import fksz.home.view.support.LocalizationUrlBuilder;
import fksz.i18n.service.LocalizationService;
import fksz.models.ConfigurationModel;
import fksz.requests.ConfigurationRequest;
import fksz.service.ConfigurationService;
import fksz.transformers.ConfigurationTransformer;

@Controller
@RequestMapping("/report")
public class ReportController extends MasterController {
	
	@Autowired ConfigurationTransformer transformer;
	@Autowired ConfigurationService service;

	public ReportController(LocalizationService localizationService, AuthenticationService authenticationService,
			LocalizationUrlBuilder localizationUrlBuilder) {
		super(localizationService, authenticationService, localizationUrlBuilder);
	}

	@ModelAttribute("configRequest")
	public ConfigurationRequest configRequest() {
		return new ConfigurationRequest();
	}

	@ModelAttribute("configModel")
	public ConfigurationModel configModel() {
		return transformer.dtoToModel(service.getByItemName(Constants.REPORT_URL_CONFIG));
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String documents(@ModelAttribute("loginRequest") LoginRequest loginRequest, BindingResult bindingResult, HttpSession httpSession) {
		authenticationService.isLoginOk(bindingResult, httpSession);
		return "report";
	}
}
