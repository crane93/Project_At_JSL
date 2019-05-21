package Action;

import java.util.Scanner;

import Constant.Operation;
import UserInterface.ConsoleUtils;
import Util.FrontController;

public class SelectMenu implements Action {

	@Override
	public void execute(Scanner sc) {

		Action action = null;
		ConsoleUtils cu = new ConsoleUtils();
		int menu = 0;
		boolean isStop = false;
		FrontController fc = new FrontController();

		do {
			cu.showMenu2(); // 로그인 후의 메뉴를 출력.
			menu = sc.nextInt();
			sc.nextLine();
			
			switch (menu) {
			case Operation.WRITENOVEL: // 새 소설 쓰기
				action = new WriteNovel();
				break;
			case Operation.READNOVEL: // 소설 열람
				action = new ReadNovel();
				break;
			case Operation.SHOWMYPAGE: // 마이페이지
				action = new MyPage();
				break;
			case Operation.SHOWRANKING: // 랭킹
				action = new ShowRanking();
				break;
			case Operation.EXIT: // 종료
				isStop = true;
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
