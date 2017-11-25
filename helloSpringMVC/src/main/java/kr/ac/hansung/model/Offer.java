package kr.ac.hansung.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/*import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString*/
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
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	public String toString() {
		return "Offer [id=" + id + ", name=" + name + ", email=" + email + ", text=" + text + "]";
	}
	
}
