package kr.ac.hansung.cse.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Product {
	private int id;
	// Hiberate 사용으로 검증 가능
	@NotEmpty(message="The product name must not be null")
	private String name;
	
	private String category;
	
	@Min(value=0, message="The product price must not be less than zero")
	private int price;
	
	@NotEmpty(message="The manufacture name must not be null")
	private String manufacture;
	
	@Min(value=0, message="The product unitInStock must not be less than zero")
	private int unitInStock;
	
	private String description;
}
