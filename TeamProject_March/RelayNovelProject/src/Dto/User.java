package Dto;
/*
 * DTO 정의 
DTO(Data Transfer Object) 는 계층간 데이터 교환을 위한 자바빈즈를 의미합니다. 
여기서 말하는 계층간의 의미는 Controller, View, Business Layer, Persistent Layer 
등을 말하며 각 계층간 데이터 교환을 위한 객체를 의미합니다. 
DTO는 로직을 가지지 않는 순수한 데이터 객체이고 getter, setter 
메소드만 가진 클래스를 의미합니다.

 User 클래스
 1. 데이터베이스의 User 테이블의 내용을 끌어와서 사용하는 Beans이다.
 2. 데이터베이스의 내용을 수정하지 않고 사용만 하는 곳이다.
 3. 수정은 dao에서 한다.

 */
public class User {
	private String id;
	private String pw;
	private String nickname;
	private String pwQuestion;
	
	public User(String id, String pw, String nickname, String pwQuestion) {
		this.id = id;
		this.pw = pw;
		this.nickname = nickname;
		this.pwQuestion = pwQuestion;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPwQuestion() {
		return pwQuestion;
	}

	public void setPwQuestion(String pwQuestion) {
		this.pwQuestion = pwQuestion;
	}
}
