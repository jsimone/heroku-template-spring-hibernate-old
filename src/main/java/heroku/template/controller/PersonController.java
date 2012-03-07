package heroku.template.controller;

import heroku.template.model.Person;
import heroku.template.service.PersonService;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PersonController {

	@Autowired
	private PersonService personService;

	@RequestMapping("/index")
	public String listPeople(Map<String, Object> map) {

		map.put("person", new Person());
		map.put("peopleList", personService.listPeople());

		return "person";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("person")
	Person person, BindingResult result) {

		personService.addPerson(person);

		return "redirect:/index";
	}

	@RequestMapping("/delete/{personId}")
	public String deletePerson(@PathVariable("personId")
	Integer personId) {

		personService.removePerson(personId);

		return "redirect:/index";
	}
}
