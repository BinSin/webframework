package kr.ac.hansung.csemall;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class OfferDAO {

	private JdbcTemplate  jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
}
