package fksz.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fksz.authentication.service.AuthenticationService;
import fksz.authentication.view.model.LoginRequest;
import fksz.domain.UserStatus;
import fksz.home.view.support.LocalizationUrlBuilder;
import fksz.i18n.service.LocalizationService;
import fksz.models.UserModel;
import fksz.requests.UserRequest;
import fksz.service.OfferService;
import fksz.service.UserService;
import fksz.transformers.UserTransformer;

@Controller
@RequestMapping("/users")
public class UserController extends MasterController{

	@Autowired
	UserTransformer userTransformer;
	@Autowired
	UserService userService;
	@Autowired
	OfferService offerService;
	
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
		userRequest.setPassword(userService.generateNewPassword());
		userRequest.setStatus(UserStatus.PENDING.toString());
		userService.save(userTransformer.requestToDto(userRequest));
		return "redirect:/users";
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteuserpost", method=RequestMethod.POST, produces = "application/json")
	public String deleteUser (int userId) {
		if (!offerService.getAllByUserId(userId).isEmpty()) {
			return JSONObject.quote("Torold elobb a felhasznalohoz tartozo offereket!");
		} else {
		userService.deleteById(userId);
		return JSONObject.quote("A felhasznalo torolve a rendszerbol");
		}
	}
	
	@RequestMapping(value="/edituserdialogpost", method=RequestMethod.POST)
	@ResponseBody
	public String editUser (int userId) throws JsonProcessingException {
		UserModel user = userTransformer.dtoToModel(userService.getById(userId));		
		ObjectMapper mapper = new ObjectMapper();
		String jsonUser = "";
		if (user != null) {
			jsonUser = mapper.writeValueAsString(user);
		}
		return jsonUser;
	}
	
	@RequestMapping(value="/sendregisteremail", method=RequestMethod.POST)
	public String sendMail (int userId) {
		userService.generateAndSendRegistrationEmailWithNewPassword(userId);
		return "redirect:/users";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String example(@ModelAttribute("loginRequest") LoginRequest loginRequest, BindingResult bindingResult, HttpSession httpSession) {
		authenticationService.isLoginOk(bindingResult, httpSession);
		if (authenticationService.getPrincipalStatus() != "ACTIVATED") {
			return "redirect:/profile";
		} else return "user_list";
	}

}
