package kr.ac.hansung.exception;

public class UserNotFoundException extends RuntimeException {

	// class의 version이 맞는지 않맞는지 확인
	// class의 버전을 나타내는 숫자
	private static final long serialVersionUID = -4451685904043827749L;
	private long userId;
	
	public UserNotFoundException(long userId) {
		this.userId = userId;
	}
	
	public long getUserId() {
		return userId;
	}
	
}
