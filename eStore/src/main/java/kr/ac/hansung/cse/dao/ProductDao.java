package kr.ac.hansung.cse.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.cse.model.Product;

@Repository
public class ProductDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dateSource) {
		jdbcTemplate = new JdbcTemplate(dateSource);
	}
	
	public List<Product> getProduct() {
		String sqlStatement = "select * from product"; // record -> object
		return jdbcTemplate.query(sqlStatement, new RowMapper<Product>() {
			// 익명클래스
			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setCategory(rs.getString("category"));
				product.setPrice(rs.getInt("price"));
				product.setManufacture(rs.getString("manufacture"));
				product.setUnitInStock(rs.getInt("unitInStock"));
				product.setDescription(rs.getString("description"));
				
				return product;
			}
		});
	}

	public boolean addProduct(Product product) {
		String name = product.getName();
		String category = product.getCategory();
		int price = product.getPrice();
		String manufacture = product.getManufacture();
		int unitInStock = product.getUnitInStock();
		String description = product.getDescription();
		
		String sqlStatement = "insert into product (name, category, price, manufacture, unitInStock, description) "
					+ "value (?,?,?,?,?,?)";
		
		return (jdbcTemplate.update(sqlStatement, new Object[]{name, category, price, manufacture, unitInStock, description}) == 1);
	}
}
