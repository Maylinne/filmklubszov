package fksz.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
import fksz.requests.UserRequest;
import fksz.service.UserService;
import fksz.transformers.UserTransformer;

@Controller
@RequestMapping("/users")
public class UserController extends MasterController{

	@Autowired
	UserTransformer userTransformer;
	
	@Autowired
	UserService userService;
	
	public UserController(LocalizationService localizationService, AuthenticationService authenticationService, LocalizationUrlBuilder localizationUrlBuilder) {
		super(localizationService, authenticationService, localizationUrlBuilder);
	}

	@ModelAttribute("userRequest")
	public UserRequest userRequest() {
		return new UserRequest();
	}
	
	@ModelAttribute("userModel")
	public UserModel userModel() {
		return new UserModel();
	}
	
	@ModelAttribute("userModels")
	public List<UserModel> getAllusers() {
		List<UserModel> users = userTransformer.dtosToModels(userService.getAll());
		return users;
	}
	
	@RequestMapping(value="/adduserpost", method=RequestMethod.POST)
	public String saveuser (UserRequest userRequest, BindingResult bindingResult) {
		userRequest.setPassword("AlmAfA01");
		userService.save(userTransformer.requestToDto(userRequest));
		return "redirect:/adduser";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String example(@ModelAttribute("loginRequest") LoginRequest loginRequest, BindingResult bindingResult, HttpSession httpSession) {
		AuthenticationService.isLoginOk(bindingResult, httpSession);
		return "user_list";
	}

}
