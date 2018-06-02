package kr.ac.hansung.cse.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.hansung.cse.model.Product;

@EnableTransactionManagement // tx:annotation-driven 이 되지 않을 때 이 annotation을 쓰면 사용할 수 있다.
@Repository
@Transactional
public class ProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Product> getProducts() {

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Product");
		List<Product> productList = query.list();

		return productList;
	}
	
	public Product getProductById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Product product = (Product)session.get(Product.class, id);
	
		return product;
	}

	public void addProduct(Product product) {

		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		session.flush();

	}

	public void deleteProduct(Product product) {

		Session session = sessionFactory.getCurrentSession();
		session.delete(product);
		session.flush();

	}

	public void updateProduct(Product product) {

		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		session.flush();

	}
}
