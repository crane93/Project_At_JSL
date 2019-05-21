package UserInterface;

import java.util.Scanner;

<<<<<<< HEAD:RelayNovelProject/src/UserInterface/Main.java
import Action.Action;
import Action.Membership;
=======
import Action.*;
import Constant.Operation;
>>>>>>> 088ed14838f1df2980ab7857432ee058d872e4fc:src2/UserInterface/Main.java
import Util.FrontController;

/*
 *  메인 클래스. 
 *  1. 시작화면을 출력해준다.
 *  2. 프론트 컨트롤러에 의해 내부 클래스들과 연동된다.
 *  3. 메인 클래스는 단순히 메인 메서드를 가지고 있는 클래스일 뿐, 그 어떠한
 *  역할도 수행하지 않는다. 다만, 그냥 처음 시작하는 문일 뿐이다.
 *  4. 그런 의미에서 프론트 컨트롤러도 그냥 문을 여는 열쇠 정도라고 보면 된다. 
 */

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean isStop = false;
		int menu = 0;

		ConsoleUtils cu = new ConsoleUtils();
		FrontController fc = new FrontController();

		do {
			cu.showMenu();
<<<<<<< HEAD:RelayNovelProject/src/UserInterface/Main.java
			System.out.println("menu = ");
			menu = Integer.parseInt(sc.nextLine());
			
			Action action = null;
			
			switch(menu) {
			case 1: // 회원가입
				action = new Membership();
				break;
			case 2: // 로그인
				
=======
			System.out.print("menu  >>");
			menu = Integer.parseInt(sc.nextLine());

			Action action = null;

			switch (menu) {
			case Operation.MEMBERSHIP: // 회원가입
				action = new Membership();
				break;
			case Operation.LOGIN: // 로그인
				action = new Login();
>>>>>>> 088ed14838f1df2980ab7857432ee058d872e4fc:src2/UserInterface/Main.java
				break;
			case 3: // 비밀번호 찾기
				break;
			case 4: // 비회원 소설열람
				break;
			case 5: // 종료
				isStop = true;
				break;
			default:
				System.out.println("메뉴에 선택이 올바르지 않습니다.");
			}

			if (action != null) {
				fc.requestProcessor(action, sc);
			}

		} while (!isStop);
		System.out.println("프로그램을 종료합니다.");
	}

}
