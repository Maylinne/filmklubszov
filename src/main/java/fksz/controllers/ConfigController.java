package fksz.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fksz.authentication.service.AuthenticationService;
import fksz.authentication.view.model.LoginRequest;
import fksz.domain.Constants;
import fksz.dto.ConfigurationDto;
import fksz.home.view.support.LocalizationUrlBuilder;
import fksz.i18n.service.LocalizationService;
import fksz.models.ConfigurationModel;
import fksz.requests.ConfigurationRequest;
import fksz.service.ConfigurationService;
import fksz.transformers.ConfigurationTransformer;

@Controller
@RequestMapping("/config")
public class ConfigController extends MasterController{

	@Autowired ConfigurationTransformer transformer;
	@Autowired ConfigurationService service;
	
	public ConfigController(LocalizationService localizationService, AuthenticationService authenticationService, LocalizationUrlBuilder localizationUrlBuilder) {
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
	
	@ModelAttribute("configUrl")
	public String configUrl() {
		return transformer.dtoToModel(service.getByItemName(Constants.REPORT_URL_CONFIG)).getValue();
	}
	
	@RequestMapping(value="/saveurl", method=RequestMethod.POST)
	public String changePsw(ConfigurationRequest configRequest, BindingResult bindingResult, ModelMap model) {
		ConfigurationDto dto = transformer.requestToDto(configRequest);
		service.save(dto);
		
		return "report";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String example(@ModelAttribute("loginRequest") LoginRequest loginRequest, BindingResult bindingResult, HttpSession httpSession) {
		authenticationService.isLoginOk(bindingResult, httpSession);
		return "config";
	}

}
