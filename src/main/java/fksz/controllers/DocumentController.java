package fksz.controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.api.services.drive.model.File;

import fksz.authentication.service.AuthenticationService;
import fksz.authentication.view.model.LoginRequest;
import fksz.driveapi.MyDriveService;
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

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity download(@RequestParam("fileId") String fileId) throws IOException {

		File driveFile = driveService.getFileById(fileId);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + driveFile.getName());
		responseHeaders.add(HttpHeaders.CONTENT_TYPE, driveFile.getMimeType());

		ByteArrayOutputStream responseArray = (ByteArrayOutputStream) driveService.downloadFile(fileId);
		
		@SuppressWarnings("unchecked")
		ResponseEntity respEnt = new ResponseEntity(responseArray.toByteArray(), responseHeaders, HttpStatus.OK);
		
		return respEnt;

	}

}
