package fksz.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fksz.authentication.service.AuthenticationService;
import fksz.authentication.view.model.LoginRequest;
import fksz.home.view.support.LocalizationUrlBuilder;
import fksz.i18n.service.LocalizationService;
import fksz.models.OfferModel;
import fksz.models.SpotModel;
import fksz.requests.OfferRequest;
import fksz.service.CutService;
import fksz.service.OfferService;
import fksz.service.SpotService;
import fksz.service.UserService;
import fksz.transformers.CutTransformer;
import fksz.transformers.OfferTransformer;
import fksz.transformers.SpotTransformer;
import fksz.transformers.UserTransformer;

@Controller
@RequestMapping("/offers")
public class OfferController extends MasterController {

	@Autowired
	OfferTransformer offerTransformer;
	@Autowired
	OfferService offerService;
	@Autowired
	UserService userService;
	@Autowired
	UserTransformer userTransformer;
	@Autowired
	CutService cutService;
	@Autowired
	CutTransformer cutTransformer;
	@Autowired
	SpotService spotService;
	@Autowired
	SpotTransformer spotTransformer;

	public OfferController(LocalizationService localizationService, AuthenticationService authenticationService,
			LocalizationUrlBuilder localizationUrlBuilder) {
		super(localizationService, authenticationService, localizationUrlBuilder);
	}

	@ModelAttribute("cutOfferModel")
	public OfferModel cutOfferModel() {
		OfferModel model = new OfferModel();
		model.setAvailableCuts(cutService.getTheAvailableCuts());
		model.setAvailableUsers(userService.allTheAvailableUsers());
		return model;
	}
	
	@ModelAttribute("spotOfferModel")
	public OfferModel spotOfferModel() {
		OfferModel model = new OfferModel();
		model.setAvailableSpots(spotService.getTheAvailableSpots());
		model.setAvailableUsers(userService.allTheAvailableUsers());
		return model;
	}
	
	
	@ModelAttribute("cutOfferRequest")
	public OfferRequest cutOfferRequest() {
		return new OfferRequest();
	}
	
	@ModelAttribute("spotOfferRequest")
	public OfferRequest spotOfferRequest() {
		return new OfferRequest();
	}

	@ModelAttribute("spots") // *kézrecsap* Ezt AJAX-al bakker!
	public List<SpotModel> getAllSpots() {
		return spotTransformer.dtosToModels(spotService.getAll());
	}

	@ModelAttribute("cutOfferModels")
	public List<OfferModel> getAllCutOffers() {
		List<OfferModel> offerModels = offerTransformer.dtosToModels(offerService.getAll());
		return offerModels.stream().filter(offerModel -> offerModel.getSpot() == null).collect(Collectors.toList());
	}

	@ModelAttribute("spotOfferModels")
	public List<OfferModel> getAllSpotOffers() {
		List<OfferModel> offers = offerTransformer.dtosToModels(offerService.getAll());
		return offers.stream().filter(offer -> offer.getCut() == null).collect(Collectors.toList());
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteofferpost", method=RequestMethod.POST, produces = "application/json")
	public String deleteOffer(int offerId) {
		offerService.deleteById(offerId);
		return JSONObject.quote("Az offer torolve.");
	}

	@RequestMapping(value ="/offerPost", method=RequestMethod.POST)
	public String saveCutOffer (OfferRequest cutOfferRequest, BindingResult bindingResult) {
		offerService.save(offerTransformer.requestToDto(cutOfferRequest));
		return "redirect:/offers";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String offer(@ModelAttribute("loginRequest") LoginRequest loginRequest, BindingResult bindingResult, HttpSession httpSession) {
		AuthenticationService.isLoginOk(bindingResult, httpSession);
		return "offer_list";
	}

}
