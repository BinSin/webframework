package testHibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//***import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity // 이 클래스에 해당되는 내용을 Hibernate가 인지하고 이를 테이블로 만들어 준다.
@Table(name="Product") // 테이블 이름 지정, 안하면 클레스 이름이 된다.)
public class Product {
	@Id
	@GeneratedValue  // 레코드의 primary key 지정
	@Column(name="product_id") // column 이름 지정, 안하면 변수가 이름이 된다.
	private int id;
	
	private String name;
	
	private int price;
	
	private String description;
}