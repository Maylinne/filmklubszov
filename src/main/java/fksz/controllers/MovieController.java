package fksz.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fksz.authentication.service.AuthenticationService;
import fksz.authentication.view.model.LoginRequest;
import fksz.home.view.support.LocalizationUrlBuilder;
import fksz.i18n.service.LocalizationService;
import fksz.models.FilmMetaModel;
import fksz.requests.CutRequest;
import fksz.requests.FilmMetaRequest;
import fksz.service.CutService;
import fksz.service.FilmMetaService;
import fksz.transformers.CutTransformer;
import fksz.transformers.FilmMetaTransformer;

@Controller
@RequestMapping("/movies")
public class MovieController extends MasterController {
	
	@Autowired
	FilmMetaTransformer filmMetaTransformer;
	
	@Autowired
	CutTransformer cutTransformer;
	
	@Autowired
	CutService cutService;
	
	@Autowired
	FilmMetaService filmMetaService;

	public MovieController(LocalizationService localizationService, AuthenticationService authenticationService, LocalizationUrlBuilder localizationUrlBuilder) {
		super(localizationService, authenticationService, localizationUrlBuilder);
	}
	
	@ModelAttribute("filmMetaRequest")
	public FilmMetaRequest filmMetaRequest() {
		return new FilmMetaRequest();
	}
	
	@ModelAttribute("cutRequest")
	public CutRequest cutRequest() {
		return new CutRequest();
	}
	
	@ModelAttribute("filmMetaModels")
	public List<FilmMetaModel> getAllFilmMetaModels() {
		List<FilmMetaModel> filmMetaModels = filmMetaTransformer.dtosToModels(filmMetaService.getAll());
		return filmMetaModels;
	}
	
	@RequestMapping(value="/addfilmmeta", method=RequestMethod.POST)
	public String saveFilmMeta (FilmMetaRequest filmMetaRequest, BindingResult bindingResult) {
		filmMetaService.save(filmMetaTransformer.requestToDto(filmMetaRequest));
		return "redirect:/movies";
	}
	
	@RequestMapping(value="/addcut", method=RequestMethod.POST)
	public String saveFilmMeta (CutRequest cutRequest, BindingResult bindingResult) {
		cutService.save(cutTransformer.requestToDto(cutRequest));
		return "redirect:/movies";
	}
	
	@RequestMapping(value="/getfilmmetabyid", method=RequestMethod.GET, headers="Accept=*/*", produces="application/json")
	public @ResponseBody FilmMetaModel pay(@RequestParam("id") int id) {
	
		FilmMetaModel film = filmMetaTransformer.dtoToModel(filmMetaService.getById(id));
		return film;
	}

	@RequestMapping(method=RequestMethod.GET)
	public String example(@ModelAttribute("loginRequest") LoginRequest loginRequest, BindingResult bindingResult, HttpSession httpSession) {
		AuthenticationService.isLoginOk(bindingResult, httpSession);
		return "film_list";
	}

}
