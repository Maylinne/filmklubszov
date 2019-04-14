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
import fksz.home.view.support.LocalizationUrlBuilder;
import fksz.i18n.service.LocalizationService;
import fksz.models.LocationModel;
import fksz.models.SpotModel;
import fksz.requests.LocationRequest;
import fksz.requests.SpotRequest;
import fksz.service.LocationService;
import fksz.service.OfferService;
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
	
	@Autowired
	OfferService offerSevice;
	
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
	
	@ResponseBody
	@RequestMapping(value="/deletelocationpost", method=RequestMethod.POST, produces = "application/json")
	public String deleteLocation (int locationId) {
		if (!locationService.getById(locationId).getSpots().isEmpty()) {
			return JSONObject.quote("Torold elobb a helyszinhez tartozo termeket!");
		} else {
			locationService.deleteById(locationId);
			return JSONObject.quote("A helyszin torolve a rendszerbol");
		}
	}
	
	@RequestMapping(value="/editlocationdialogpost", method=RequestMethod.POST)
	@ResponseBody
	public String editLocation (int locationId) throws JsonProcessingException {
		LocationModel location = locationTransformer.dtoToModel(locationService.getById(locationId));		
		ObjectMapper mapper = new ObjectMapper();
		String jsonLocation = "";
		if (location != null) {
			jsonLocation = mapper.writeValueAsString(location);
		}
		return jsonLocation;
	}
	
	@ResponseBody
	@RequestMapping(value="/deletespotpost", method=RequestMethod.POST, produces = "application/json")
	public String deleteSpot (int spotId) {
		if (!offerSevice.getAllBySpotId(spotId).isEmpty()) {
			return JSONObject.quote("Elobb torold az ezt a termet tartalmazo offereket!");
		} else {
			spotService.deleteById(spotId);
			return JSONObject.quote("A helyszin torolve a rendszerbol");
		}
	}
	
	
	@RequestMapping(value="/editspotdialogpost", method=RequestMethod.POST)
	@ResponseBody
	public String editSpot (Integer spotId) throws JsonProcessingException {
		SpotModel spot = spotTransformer.dtoToModel(spotService.getById(spotId));		
		ObjectMapper mapper = new ObjectMapper();
		String jsonSpot = "";
		if (spot != null) {
			jsonSpot = mapper.writeValueAsString(spot);
		}
		return jsonSpot;
	}
	
	
	@RequestMapping(value="/addlocation", method=RequestMethod.POST)
	public String saveLocation (LocationRequest locationRequest, BindingResult bindingResult) {
		locationService.save(locationTransformer.requestToDto(locationRequest));
		return "redirect:/locations";
	}
	
	@RequestMapping(value="/addspot", method=RequestMethod.POST)
	public String saveSpot (SpotRequest spotRequest, BindingResult bindingResult) {
		spotService.save(spotTransformer.requestToDto(spotRequest));
		return "redirect:/locations";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String addLocation(@ModelAttribute("loginRequest") LoginRequest loginRequest, BindingResult bindingResult, HttpSession httpSession) {
		AuthenticationService.isLoginOk(bindingResult, httpSession);
		return "location_list";
	}
	
	

}
