package UserInterface;

import static Constant.Operation.*;

import java.util.Scanner;

import Action.MyPage;
import Dto.Novel;
import Dto.User;

/*
 * 콘솔유틸
 * 1. 화면에 출력되는 각종 메뉴들을 메서드로 갖고 있는 유틸 클래스이다.
 * 2. 
 */

public class ConsoleUtils {

	Scanner sc = new Scanner(System.in);

	public void showMenu() {
		System.out.println();
		System.out.println("===== Relay Novel =====");
		System.out.println("      1. 회원가입");
		System.out.println("      2. 로그인");
		System.out.println("      3. 비밀번호 찾기");
		System.out.println("      4. 비회원 소설열람");
		System.out.println("      0. 종료");
		System.out.println("=======================");
		System.out.println();
	}

	////////// 1. 가입
	public User joinMembership(Scanner sc) {
		System.out.println("===== 회원가입 Menu =====");
		System.out.print("      a. 아이디  >>");
		String id = sc.nextLine();
		System.out.print("      b. 비밀번호  >>");
		String pw = sc.nextLine();
		System.out.print("      c. 닉네임  >>");
		String nickname = sc.nextLine();
		System.out.print("      d. 비밀번호 찾기 질문 : 아버지 성함은?  >>");
		String pwQeustion = sc.nextLine();
		return new User(id, pw, nickname, pwQeustion); // 빈파일 객체로 리턴
	}

	////////// 1-1. 성공, 1-2. 실패
	public void joinSuccess(User user) {
		System.out.println(user.getId() + "님 회원가입 축하드립니다.");

	}

	public void joinFail() {
		System.out.println("회원가입에 실패하셨습니다.");

	}

	////////// 2. 로그인
	public User login(Scanner sc) {
		System.out.println("####login execute");
		System.out.println("아이디 : ");
		String id = sc.nextLine();
		System.out.println("비밀번호 : ");
		String pw = sc.nextLine();

		return new User(id, pw);
	}

	////////// 3. 비밀번호 찾기
	public User findPw(Scanner sc) {
		System.out.print("아이디를 입력해주세요  >>");
		String id = sc.nextLine();
		System.out.print("아버지 성함은?  >>");
		String pwAnswer = sc.nextLine();
		return new User(id, pwAnswer, "findPw");
	}

	////////// 4. 비회원 소설읽기 > call ReadAllmember

	////////// 0. 종료
	public void Close() { // 0. 종료
		System.out.print("정말 종료하시겠습니까?(Y/N) >>");
		String answer = sc.nextLine();
		if (answer.equals("Y") || answer.equals("y")) {
			System.out.println("프로그램을 종료합니다.");
			System.exit(0);
		} else if (answer.equals("N") || answer.equals("n")) {
			showMenu();
		} else {
			System.out.println("다시 입력해주세요.(Y/N)");
		}
	}

	
	public void showMenu2() { // 로그인 후 메뉴
		System.out.println();
		System.out.println("===== 메뉴를 선택하세요 =====");
		System.out.println("      1. 새 작품쓰기");
		System.out.println("      2. 작품열람");
		System.out.println("      3. 마이페이지");
		System.out.println("      4. 랭킹");
		System.out.println("      0. 종료");
		System.out.println("========================");
		System.out.println();
	}

	////////// 1. 새 작품
	public Novel writeNovel(Scanner sc) {
		System.out.println("소설의 제목을 입력하세요");
		String title = sc.nextLine();
		System.out.println("40자 이내의 소설 한줄을 입력하세요");
		String contents = sc.nextLine();
		// for문을 돌려서 8줄만 입력하게. 쓴 소설저장은 리스트에? 배열에?

		return new Novel(title, contents);
	}

	////////// 2. 작품 열람
	public Novel showNovel(Scanner sc) {
		int novelNumber = sc.nextInt();
		return new Novel(novelNumber);
	}

	////////// 3. 마이 페이지
	public int myPage(Scanner sc) { // 마이페이지
		System.out.println();
		System.out.println("===== 나의 정보 =====");
		System.out.println("      a. 아이디 : " + MyPage.me.getId());
		System.out.println("      b. 비밀번호 : " + MyPage.me.getPw());
		System.out.println("      c. 닉네임 : " + MyPage.me.getNickname());
		System.out.println("      d. 비밀번호 찾기 질문 : 아버지 성함은? " + MyPage.me.getAnswerForPw());
		System.out.println("      e. 회원등급 : " + MyPage.me.getGrade());
		System.out.println("      f. 내 소설 갯수 : " + MyPage.me.getCountMyNovel() + "개");
		System.out.println("      g. 내가 받은 좋아요 갯수 : " + MyPage.me.getCountLike() + "개");
		System.out.println();
		System.out.println("1. 정보수정   2. 회원탈퇴   3. 뒤로가기 >>");
		int menu = sc.nextInt();
		return menu;

	}

	////////// 3-1. 정보수정, 3-2. 회원탈퇴, 3-3. 뒤로가기
	public int myInfoModi() {
		System.out.println("---------------------------------");
		System.out.println("1. 닉네임 수정   2. 비밀번호 수정   3. 뒤로가기");
		System.out.println("---------------------------------");
		int menu = sc.nextInt();
		return menu;
	}
	
	////////// 3-1-1. 닉네임 수정, 3-1-2. 비밀번호 수정, 3-1-3. 뒤로가기


	
	
	public void goBack() { // 뒤로가기 ->
		showMenu2(); // 메뉴선택창으로 돌아간다.
	}

	////////// 4. 랭킹
	public void ranking() {
		System.out.println("---------------------------------");
		System.out.println("1. 추천순으로 보기   2. 조회순으로 보기   3. 회원순위   4. 뒤로가기");
		System.out.println("---------------------------------");
	}

	////////// 0. 로그아웃
	public String logout() {
		System.out.println("정말 로그아웃 하시겠습니까?(Y/N)");
		return sc.nextLine();
	}

}
