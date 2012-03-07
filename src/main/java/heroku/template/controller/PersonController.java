package heroku.template.controller;

import heroku.template.model.Person;

import java.util.Map;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@Transactional
public class PersonController {

    @Autowired
    private SessionFactory sessionFactory;

    @RequestMapping("/index")
    public String listPeople(Map<String, Object> map) {

        map.put("person", new Person());
        map.put("peopleList", sessionFactory.getCurrentSession().createCriteria(Person.class).list());

        return "person";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("person")
                            Person person, BindingResult result) {

        sessionFactory.getCurrentSession().save(person);

        return "redirect:/index";
    }

    @RequestMapping("/delete/{personId}")
    public String deletePerson(@PathVariable("personId")
                               Integer personId) {

        Person person = (Person)sessionFactory.getCurrentSession().get(Person.class, personId);
        sessionFactory.getCurrentSession().delete(person);

        return "redirect:/index";
    }
}
