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
import fksz.models.LocationModel;
import fksz.requests.LocationRequest;
import fksz.requests.SpotRequest;
import fksz.service.LocationService;
import fksz.service.SpotService;
import fksz.transformers.LocationTransformer;
import fksz.transformers.SpotTransformer;

@Controller
@RequestMapping("/locations")
public class LocationController extends MasterController {
	
	@Autowired
	LocationService locationService;
	
	@Autowired
	LocationTransformer locationTransformer;
	
	@Autowired
	SpotService spotService;
	
	@Autowired
	SpotTransformer spotTransformer;
	
	public LocationController(LocalizationService localizationService, AuthenticationService authenticationService, LocalizationUrlBuilder localizationUrlBuilder) {
		super(localizationService, authenticationService, localizationUrlBuilder);
	}
	
	@ModelAttribute("locationRequest")
	public LocationRequest locationRequest() {
		return new LocationRequest();
	}
	
	@ModelAttribute
	public SpotRequest spotRequest() {
		return new SpotRequest();
	}
	
	@ModelAttribute("locationModels")
	public List<LocationModel> getAllLocations() {
		List<LocationModel> locations = locationTransformer.dtosToModels(locationService.getAll());
		return locations;
	}
	
	@RequestMapping(value="/addlocation", method=RequestMethod.POST)
	public String saveLocation (LocationRequest locationRequest, BindingResult bindingResult) {
		locationService.save(locationTransformer.requestToDto(locationRequest));
		return "redirect:/location";
	}
	
	@RequestMapping(value="/addspot", method=RequestMethod.POST)
	public String saveSpot (SpotRequest spotRequest, BindingResult bindingResult) {
		spotService.save(spotTransformer.requestToDto(spotRequest));
		return "redirect:/location";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String addLocation(@ModelAttribute("loginRequest") LoginRequest loginRequest, BindingResult bindingResult, HttpSession httpSession) {
		AuthenticationService.isLoginOk(bindingResult, httpSession);
		return "location_list";
	}
	
	

}
