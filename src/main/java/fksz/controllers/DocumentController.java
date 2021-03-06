package fksz.controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.api.services.drive.model.File;

import fksz.authentication.service.AuthenticationService;
import fksz.authentication.view.model.LoginRequest;
import fksz.googletools.MyDriveService;
import fksz.home.view.support.LocalizationUrlBuilder;
import fksz.i18n.service.LocalizationService;

@Controller
@RequestMapping("/documents")
public class DocumentController extends MasterController {

	@Autowired
	MyDriveService driveService;

	public DocumentController(LocalizationService localizationService, AuthenticationService authenticationService,
			LocalizationUrlBuilder localizationUrlBuilder) {
		super(localizationService, authenticationService, localizationUrlBuilder);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity download(@RequestParam("fileId") String fileId) throws IOException {
		File driveFile = driveService.getFileById(fileId);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + driveFile.getName());
		responseHeaders.add(HttpHeaders.CONTENT_TYPE, driveFile.getMimeType());
		
		ResponseEntity respEnt = null;
		try {
			ByteArrayOutputStream responseArray = (ByteArrayOutputStream) driveService.downloadFile(fileId);
			
			respEnt = new ResponseEntity(responseArray.toByteArray(), responseHeaders, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return respEnt;

	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String documents(@ModelAttribute("loginRequest") LoginRequest loginRequest, BindingResult bindingResult, HttpSession httpSession) {
		authenticationService.isLoginOk(bindingResult, httpSession);
		return "documents";
	}

}
