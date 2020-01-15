package com.application.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.application.util.DetailModule;
import com.application.util.Import;
import com.application.util.PageName;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.application.service.QueryMethodsService;
@SessionAttributes({"currentUser"})
@Controller
public class ImportControlleur {
	
	  private static final Logger log = LogManager.getLogger(ImportControlleur.class);

	@Autowired
	private DetailModule moduleActif;
	
	@Autowired
	private QueryMethodsService  query;
	
	@RequestMapping(value = "/import")
	public String init(HttpServletRequest request, Model model) throws Exception {
		model.addAttribute( "file", "" );
		return definitNavigationEtModule(model, PageName.IMPORT);
	}
	@RequestMapping(value = "/import/submit")
	public String submit(@ModelAttribute( "file" ) String file, HttpServletRequest request, Model model) throws Exception {
		System.err.println(file);
		Import.importMethode(query, file);
		return definitNavigationEtModule(model, PageName.IMPORT);
	}

	private String definitNavigationEtModule( Model model, String page) {
		moduleActif.setModuleAccueil( true );
		model.addAttribute( "moduleActif", moduleActif );
		return page;
	}

}
