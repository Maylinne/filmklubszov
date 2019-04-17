package fksz.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
import fksz.models.OfferModels;
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

	@Autowired OfferTransformer offerTransformer;
	@Autowired OfferService offerService;
	@Autowired UserService userService;
	@Autowired UserTransformer userTransformer;
	@Autowired CutService cutService;
	@Autowired CutTransformer cutTransformer;
	@Autowired SpotService spotService;
	@Autowired SpotTransformer spotTransformer;
	
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

	
	
	@ModelAttribute("cutOfferModels")
	public OfferModels getAllCutOffers() {
		OfferModels offerModels = new OfferModels();
		List<OfferModel> offers = offerTransformer.dtosToModels(offerService.getAll());
		offers = offers.stream().filter(offer -> offer.getSpot() == null).collect(Collectors.toList());
		offerModels.setOffers(offers);
		offerModels.setPrincipalId(authenticationService.getPrincipalId());
		return offerModels;
	}
	
	@RequestMapping(value="/allcutoffers", method=RequestMethod.GET)
	public String allCutOffers(@ModelAttribute("loginRequest") LoginRequest loginRequest, BindingResult bindingResult, HttpSession httpSession, ModelMap  model) {
		authenticationService.isLoginOk(bindingResult, httpSession);
		model.addAttribute("isMine", false);
		return authenticationService.isPrincipalActivated("cut_offer_list");
	}
	
	@RequestMapping(value="/mycutoffers", method=RequestMethod.GET)
	public String myCutOffers(@ModelAttribute("loginRequest") LoginRequest loginRequest, BindingResult bindingResult, HttpSession httpSession, ModelMap model) {
		authenticationService.isLoginOk(bindingResult, httpSession);
		model.addAttribute("isMine", true);
		return authenticationService.isPrincipalActivated("cut_offer_list");
	}

	@ModelAttribute("spotOfferModels")
	public List<OfferModel> getAllSpotOffers() {
		List<OfferModel> offers = offerTransformer.dtosToModels(offerService.getAll());
		return offers.stream().filter(offer -> offer.getCut() == null).collect(Collectors.toList());
	}
	
	@RequestMapping(value="/allspotoffers", method=RequestMethod.GET)
	public String allSpotOffers(@ModelAttribute("loginRequest") LoginRequest loginRequest, BindingResult bindingResult, HttpSession httpSession) {
		authenticationService.isLoginOk(bindingResult, httpSession);
		return authenticationService.isPrincipalActivated("spot_offer_list");
	}
	
	@ModelAttribute("mySpotOfferModels")
	public List<OfferModel> getMySpotOffers() {
		List<OfferModel> offers = offerTransformer.dtosToModels(offerService.getAll());
		return offers.stream().filter(offer -> offer.getCut() == null && offer.getPartner().getId() == authenticationService.getPrincipalId()).collect(Collectors.toList());
	}
	
	@RequestMapping(value="/myspotoffers", method=RequestMethod.GET)
	public String mySpotOffers(@ModelAttribute("loginRequest") LoginRequest loginRequest, BindingResult bindingResult, HttpSession httpSession) {
		authenticationService.isLoginOk(bindingResult, httpSession);
		return authenticationService.isPrincipalActivated("spot_offer_list");
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteofferpost", method=RequestMethod.POST, produces = "application/json")
	public String deleteOffer(int offerId) {
		offerService.deleteById(offerId);
		return JSONObject.quote("Az offer torolve.");
	}

	@RequestMapping(value ="/offerPost", method=RequestMethod.POST)
	public String saveCutOffer (OfferRequest offerRequest, BindingResult bindingResult) {
		offerService.save(offerTransformer.requestToDto(offerRequest));
		return "redirect:/offers";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String offer(@ModelAttribute("loginRequest") LoginRequest loginRequest, BindingResult bindingResult, HttpSession httpSession) {
		authenticationService.isLoginOk(bindingResult, httpSession);
		return authenticationService.isPrincipalActivated("offer_list");
	}

}
