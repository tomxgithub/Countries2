package org.sambasoft.controllers;

import javax.validation.Valid;

//import org.codehaus.groovy.tools.ErrorReporter;
import org.sambasoft.entities.Country;
import org.sambasoft.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * This application is going to have just one html page, so we need to create
 * the methods that will return the page in local host 8082
 * 
 * @author xaymo
 *
 */
@Controller // We needed to add controller annotation
public class CountryController {

	@Autowired // Inject here is the repository
	private CountryRepository countryRepo;

	/**
	 * Pass data (Model) to this page with the @RequestParam set to default value
	 * 
	 * @param model
	 * @param page
	 * @return
	 */
	@GetMapping("/")
	public String showPage(Model model, @RequestParam(defaultValue = "0") int page) {
		// Pass the 'data' to the model attribute and set pagenate value
		model.addAttribute("data", countryRepo.findAll(new PageRequest(page, 4))); // setting the data page
		model.addAttribute("currentPage", page); // passing back the current page to be display on web page
		return "index"; // This the name of the main page

	}

	/**
	 * This method will save to the country table
	 * 
	 * @param country object
	 * @return to home/index page
	 */
	@PostMapping("/save")
	public String save(@ModelAttribute @Valid Country country, Errors error, Model model) {
		if (error.hasErrors()) {
			return "redirect:/";
		}
		countryRepo.save(country);
		return "redirect:/";
	}

	/**
	 * This method will read id and delete from thet table
	 * 
	 * @param id
	 * @return back to the main html
	 */
	@GetMapping("/delete") // return String object
	public String delete(Integer id) {
		countryRepo.delete(id);
		return "redirect:/";
	}

	@GetMapping("/edit") // return String object
	public String addNew(Model model) {
		model.addAttribute(new Country());
		return "edit";
	}

	@PostMapping("/saveEdit")
	public String saveEdit(@ModelAttribute @Valid Country country, Errors error, Model model) {
		if (error.hasErrors()) {
			return "edit";
		}
		countryRepo.save(country);
		return "redirect:/";
	}

	/**
	 * This method will be using getMapping and ResponseBody for the using jQuery
	 * 
	 * @param id
	 * @return Country object
	 */
	@GetMapping("/fineOne") // using the Country object
	@ResponseBody // we are going to use jquery
	public Country fineOne(Integer id) {
		return countryRepo.findOne(id);
	}
}
