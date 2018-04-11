package testHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class testMain1 {

	private static SessionFactory sessionFactory;
	
	public static void main(String[] args) {
		
		/*
		Configuration conf = new Configuration();
		conf.confgure("hibernate.cfg.xml"); // ()라고 해도 된다.
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
		
		category1.getProducts().add(product1);
		
		Product product2 = new Product();
		product2.setName("Desktop");
		product2.setPrice(2000000);
		product2.setDescription("Powerful Desktop!!");
		product2.setCategory(category1);
		
		category1.getProducts().add(product2);
		
		Product product3 = new Product();
		product3.setName("Sonata");
		product3.setPrice(10000000);
		product3.setDescription("대중적인 자동차!!!");
		product3.setCategory(category2);
		
		category2.getProducts().add(product3);
		
		Session session = sessionFactory.openSession(); // 세션 만들고
		Transaction tx = session.beginTransaction(); // 트렌젝션 만듬
		
		
		session.save(product1);
		session.save(product2);
		session.save(product3);
		
		
		session.save(category1);
		session.save(category2);
		
		// product1.setCategory(null); // 연결성을 끊어줘야 한다.
		// session.delete(product1); // exception 발생한다!
		
		// product3는 연결된 category가 하나여서 그냥 지워도 되지만
		// product1과 2는 서로 연결되어 있기 때문에 정보를 지우기 전에 category를 null로 해야 지워진다. 
		
		//session.delete(category1); // 연결되 있는 자식들을 모두 없앤다.
		
		tx.commit();
		session.close();
		
	}
	
}