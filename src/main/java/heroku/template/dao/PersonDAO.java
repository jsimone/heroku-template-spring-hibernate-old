package heroku.template.dao;

import heroku.template.model.Person;

import java.util.List;


public interface PersonDAO {
	
	public void addPerson(Person person);
	public List<Person> listPeople();
	public void removePerson(Integer id);
}
