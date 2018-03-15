package kr.ac.hansung.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Offer {
	
	private int id;
	
	// 이 조건 만족하지 않으면 에러메세지로 message 저장
	@Size(min=2, max=20, message="Name must be between 2 and 100 chars")
	private String name;
	
	@Email(message="Please provide a valid email address")
	@NotEmpty(message="The email address cannot be empty")
	private String email;
	
	@Size(min=1, max=100, message="Name must be between 2 and 100 chars")
	private String text;

}
