package testHibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class testMain2 {
	
	private static SessionFactory sessionFactory;
	
	public static void main(String[] args) {
		
		sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Person person1 = new Person();
		person1.setFirstName("Sin");
		person1.setLastName("Bin");
		
		License license1 = new License();
		license1.setLicenseNumber("111111");
		license1.setIssueDate(new Date());
		license1.setPerson(person1);
		
		person1.setLicense(license1);
		
		Person person2 = new Person();
		person2.setFirstName("Min");
		person2.setLastName("Sin");
		
		License license2 = new License();
		license2.setLicenseNumber("222222");
		license2.setIssueDate(new Date());
		license2.setPerson(person2);
		
		person2.setLicense(license2);
		
		Session session = sessionFactory.openSession(); // 세션 만들고
		Transaction tx = session.beginTransaction(); // 트렌젝션 만듬
		
		session.save(license1);
		session.save(license2);
		
		
		session.save(person1);
		session.save(person2);
		
		
		tx.commit();
		session.close();
		
	}
	
}