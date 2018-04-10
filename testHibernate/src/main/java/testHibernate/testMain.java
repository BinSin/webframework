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
		
		Category category1 = new Category();
		category1.setName("Computer");
		
		Category category2 = new Category();
		category2.setName("Car");
		
		sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Product product1 = new Product();
		product1.setName("notebook");
		product1.setPrice(2000);
		product1.setDescription("Awesome notebook!!!");
		product1.setCategory(category1);
		
		Product product2 = new Product();
		product2.setName("Desktop");
		product2.setPrice(2000000);
		product2.setDescription("Powerful Desktop!!");
		product2.setCategory(category1);
		
		Product product3 = new Product();
		product3.setName("Sonata");
		product3.setPrice(10000000);
		product3.setDescription("대중적인 자동차!!!");
		product3.setCategory(category2);
		
		Session session = sessionFactory.openSession(); // 세션 만들고
		Transaction tx = session.beginTransaction(); // 트렌젝션 만듬
		
		session.save(product1);
		session.save(product2);
		session.save(product3);
		
		tx.commit();
		session.close();
		
	}
	
}