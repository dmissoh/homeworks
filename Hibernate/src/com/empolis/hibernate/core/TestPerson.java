package com.empolis.hibernate.core;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class TestPerson {

	public static void main(String[] args) {
		Session session = SessionFactoryUtil.getSessionFactory()
				.getCurrentSession();
		session.beginTransaction();
		createPerson(session);
		queryPerson(session);
	}

	@SuppressWarnings("unchecked")
	private static void queryPerson(Session session) {
		Query query = session.createQuery("from Person");
		List<Person> list = query.list();
		java.util.Iterator<Person> iter = list.iterator();
		while (iter.hasNext()) {
			Person person = iter.next();
			System.out.println("Person: \"" + person.getFirstName() + "\", "
					+ person.getLastName() + "\", " + person.getAddress());
		}
		session.getTransaction().commit();
	}

	public static void createPerson(Session session) {
		Person person = new Person();
		person.setFirstName("Kay");
		person.setLastName("Drangmeister");
		person.setAddress("Rimpar");
		session.save(person);
	}
}
