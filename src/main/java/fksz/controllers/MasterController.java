package fksz.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.google.api.services.drive.model.File;

import fksz.authentication.service.AuthenticationService;
import fksz.authentication.view.controller.LoginFormController;
import fksz.authentication.view.model.LoginRequest;
import fksz.googletools.MyDriveService;
import fksz.home.view.model.HomepageModel;
import fksz.home.view.model.LanguageUrlMapping;
import fksz.home.view.support.LocalizationUrlBuilder;
import fksz.i18n.service.LocalizationService;

public class MasterController {
	
	@Autowired
	MyDriveService driveService;
	
	protected LocalizationService localizationService;
	protected AuthenticationService authenticationService;
	protected LocalizationUrlBuilder localizationUrlBuilder;
	
	@Autowired
	public MasterController(LocalizationService localizationService, AuthenticationService authenticationService, LocalizationUrlBuilder localizationUrlBuilder) {
		super();
		this.localizationService = localizationService;
		this.authenticationService = authenticationService;
		this.localizationUrlBuilder = localizationUrlBuilder;
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
	
	
	@ModelAttribute("driveFiles")
	public List<File> driveFiles() throws IOException {
		List<File> driveFiles = new ArrayList<>();
		driveFiles = driveService.getGoogleFilesByParent("FilmklubszovPublikus");
		System.out.println("You can rest here for a while...");
		return driveFiles;
	}
	
	private List<LanguageUrlMapping> getLanguageSelectors() {
		return localizationUrlBuilder.buildAccessibleLanguageSelectors(localizationService.getAccessibleLanguages());
	}
	
	@ModelAttribute("loginRequest")
	public LoginRequest createLoginRequest() {
		return new LoginRequest();
	}
	
	
	public void homepage(@ModelAttribute("loginRequest") LoginRequest loginRequest, BindingResult bindingResult, HttpSession httpSession) {
		authenticationService.isLoginOk(bindingResult, httpSession);
	}

}
