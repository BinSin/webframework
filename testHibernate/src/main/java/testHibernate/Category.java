package testHibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Category {

	@Id
	@GeneratedValue
	@Column(name="product_id")
	private int id;
	
	private String name;
	
	@OneToMany(mappedBy="category", cascade=CascadeType.ALL, fetch=FetchType.LAZY) // foreign key를 가지고 있는 필드, category 날아가면 product도 날라간다.
	private Set<Product> products = new HashSet<Product>(); // LAZY(default) : category 읽을 때 product의 정보를 모두 읽을 필요 없는데(perfermance에 영향), 필요할 때만 읽는다. 
}
