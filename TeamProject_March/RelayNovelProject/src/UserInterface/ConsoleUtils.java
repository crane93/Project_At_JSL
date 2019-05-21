package UserInterface;

import java.util.Scanner;

import Dto.User;

/*
 * 콘솔유틸
 * 1. 화면에 출력되는 각종 메뉴들을 메서드로 갖고 있는 유틸 클래스이다.
 * 2. 
 */

public class ConsoleUtils {

	public void showMenu() {
		System.out.println("== Relay Novel ==");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("3. 비밀번호 찾기");
		System.out.println("4. 비회원 소설열람");
		System.out.println("0. 종료");
		System.out.println("=================");

	}

	public User JoinMembership(Scanner sc) {
		System.out.println("== 회원가입 Menu ==");
		System.out.println("a. 아이디 : ");
		String id = sc.nextLine();
		System.out.println("b. 비밀번호 : ");
		String pw = sc.nextLine();
		System.out.println("c. 닉네임 : ");
		String nickname = sc.nextLine();
		System.out.println("d. 비밀번호 찾기 질문 : 아버지 성함은?");
		String pwQeustion = sc.nextLine();
		return new User(id, pw, nickname, pwQeustion);

	}

	public void JoinSuccess(User user) {
		// TODO Auto-generated method stub

	}

	public void JoinFail(User user) {
		// TODO Auto-generated method stub

	}

}
