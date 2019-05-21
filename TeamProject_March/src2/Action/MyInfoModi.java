package Action;

import static Constant.Operation.GO_BACK;
import static Constant.Operation.MODI_NICKNAME;
import static Constant.Operation.MODI_PW;

import java.util.Scanner;

import Dao.UserDao;
import UserInterface.ConsoleUtils;

public class MyInfoModi implements Action {

	@Override
	public void execute(Scanner sc) {
		MyPage smp = new MyPage();
		ConsoleUtils cu = new ConsoleUtils();
		UserDao ud = new UserDao();
		
		int menu = cu.myInfoModi();

		switch (menu) {
		case MODI_NICKNAME:
			ud.modiNickname(sc);
			break;
		case MODI_PW:
			ud.modiPw(sc);
			break;
		case GO_BACK:
			smp.execute(sc); // 어떻게 하면 내정보 페이지로 갈까...
			break;
		default:
			System.out.println("다시 입력해주세요.>>");
		}
	}
}
