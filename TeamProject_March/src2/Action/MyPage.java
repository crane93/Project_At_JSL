package Action;

import static Constant.Operation.MYINFOMODI;
import static Constant.Operation.SELECTMENU;
import static Constant.Operation.UNREGISTER;

import java.util.Scanner;

import Dto.User;
import UserInterface.ConsoleUtils;
import Util.FrontController;

public class MyPage implements Action {
	public static User me = new User();

	@Override
	public void execute(Scanner sc) {
		Action action = null;
		ConsoleUtils cu = new ConsoleUtils();
		int menu = 0;
		User me = null;
		FrontController fc = new FrontController();
		boolean isStop = false;

		menu = cu.myPage(sc);
		do { // 1.정보수정 2.회원탈퇴 3.뒤로가기
			switch (menu) {
			case MYINFOMODI: // 정보수정
				action = new MyInfoModi();
				break;
			case UNREGISTER: // 회원탈퇴
				action = new Unregister();
				break;
			case SELECTMENU: // 뒤로가기
				action = new SelectMenu();
				break;
			default:
				System.out.println("메뉴에 선택이 올바르지 않습니다..");
				break;
			}

			if (action != null) {
				fc.requestProcessor(action, sc);
			}

		} while (!isStop);
	}

}
