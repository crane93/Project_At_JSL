package Dto;

public class User {
	private String id;
	private String pw;
	private String nickname;
	private String grade;
	private int countMyNovel;
	private int countLike;
	private String answerForPw;	
	
	public User() {
		
	}
	
	public User(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	public User(String id, String answerForPw, String pw) {
		this.id = id;
		this.answerForPw = answerForPw;
	}
	
	public User(String nickname, String grade, int countLike) {
		this.nickname = nickname;
		this.grade = grade;
		this.countLike = countLike;
	}
	
	public User(String id, String pw, String nickname, String answerForPw) {
		this.id = id;
		this.pw = pw;
		this.nickname = nickname;
		this.answerForPw = answerForPw;
	}

	public User(String id, String pw, String nickname, String grade, int countMyNovel, int countLike, String answerForPw) {
		this.id = id;
		this.pw = pw;
		this.nickname = nickname;
		this.grade = grade;
		this.countMyNovel = countMyNovel;
		this.countLike = countLike;
		this.answerForPw = answerForPw;	
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
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getCountMyNovel() {
		return countMyNovel;
	}
	public void setCountMyNovel(int countMyNovel) {
		this.countMyNovel = countMyNovel;
	}
	public int getCountLike() {
		return countLike;
	}
	public void setCountLike(int countLike) {
		this.countLike = countLike;
	}
	public String getAnswerForPw() {
		return answerForPw;
	}
	public void setAnswerForPw(String answerForPw) {
		this.answerForPw = answerForPw;
	}

}
