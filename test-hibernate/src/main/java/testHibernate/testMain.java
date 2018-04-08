package testHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class testMain {

	private static SessionFactory sessionFactory;
	
	public static void main(String[] args) {
		
		/*
		Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml"); // ()라고 해도 된다.
		sessionFactory = conf.buildSessionFactory();
		*/
		
		sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Product product = new Product();
		product.setName("notebook");
		product.setPrice(2000);
		product.setDescription("Awesome notebook!!!");
		
		Session session = sessionFactory.openSession(); // 세션 만들고
		Transaction tx = session.beginTransaction(); // 트렌젝션 만듬
		
		session.save(product);
		
		tx.commit();
		session.close();
		
	}
	
}
