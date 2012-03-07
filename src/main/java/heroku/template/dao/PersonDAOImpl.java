package heroku.template.dao;

import heroku.template.model.Person;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDAOImpl implements PersonDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addPerson(Person person) {
		sessionFactory.getCurrentSession().save(person);
	}

	public List<Person> listPeople() {

		return sessionFactory.getCurrentSession().createQuery("from Person")
				.list();
	}

	public void removePerson(Integer id) {
		Person person = (Person) sessionFactory.getCurrentSession().load(
				Person.class, id);
		if (null != person) {
			sessionFactory.getCurrentSession().delete(person);
		}

	}
}
