package testHibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//***import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity // 이 클래스에 해당되는 내용을 Hibernate가 인지하고 이를 테이블로 만들어 준다.
@Table(name="Product") // 테이블 이름 지정, 안하면 클레스 이름이 된다.)
public class Product {
	@Id // 레코드의 primary key 로 지정
	@GeneratedValue  // 자동적으로 생성
	@Column(name="product_id") // column 이름 지정, 안하면 변수가 이름이 된다.
	private int id;
	
	private String name;
	
	private int price;
	
	private String description;
	
	//@ManyToOne(cascade=CascadeType.ALL) // persist, delete 시에 이것도 함께 이루어짐 -> product 설정 시 category도 설정된다.
	@ManyToOne
	@JoinColumn(name="category_id") // category를 가리키는 reference -> foreign key
	private Category category;
}