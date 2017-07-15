/**
 * 
 */
package com.bibernate.study;

import java.time.LocalDate;
import java.time.Month;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.study.dto.Address;
import com.hibernate.study.dto.UserDetails;

/**
 * @author Pete
 *
 */
public class UserDetailsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Address adr = new Address();
		adr.setAddressLineOne("10 Hill View");
		adr.setAddressLineTwo("Blackhorse Lane");
		adr.setAddressLineThree("Bristol");
		adr.setAddressLineFive("BS16 6CC");

		Address adr2 = new Address();
		adr2.setAddressLineOne("12 Hill View");
		adr2.setAddressLineTwo("Blackhorse Lane");
		adr2.setAddressLineThree("Bristol");
		adr2.setAddressLineFive("BS16 6CC");

		UserDetails user = new UserDetails();
		// user.setUserId(1); @GeneratedValue
		user.setFirstName("First Name");
		user.setFirstName("Last Name");
		user.setAddress(adr);
		user.setJoinedDate(LocalDate.of(1977, Month.SEPTEMBER, 24));

		user.getPreviousAddresses().add(adr);
		user.getPreviousAddresses().add(adr2);

		UserDetails user2 = new UserDetails();
		user2.setFirstName("John");
		user2.setFirstName("Smith");
		user2.setAddress(adr);
		user2.setJoinedDate(LocalDate.of(2015, Month.SEPTEMBER, 9));

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		// save model object to db
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(user2);
		session.getTransaction().commit();

		user = null;

		// fetch user
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = session.get(UserDetails.class, 1);
		System.out.println("User retrieved " + user.getFullName());

	}

}
