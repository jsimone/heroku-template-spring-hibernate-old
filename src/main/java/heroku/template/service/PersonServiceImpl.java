package heroku.template.service;

import heroku.template.dao.PersonDAO;
import heroku.template.model.Person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDAO personDAO;
	
	@Transactional
	public void addPerson(Person person) {
		personDAO.addPerson(person);
	}

	@Transactional
	public List<Person> listPeople() {

		return personDAO.listPeople();
	}

	@Transactional
	public void removePerson(Integer id) {
		personDAO.removePerson(id);
	}
}
