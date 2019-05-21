package Action;

import java.util.Scanner;

import Dao.UserDao;
import Dto.User;
import UserInterface.Main;

public class Unregister implements Action{

	@Override
	public void execute(Scanner sc) {
		UserDao ud = new UserDao();
		while (true) {
			System.out.println("1. 비밀번호를 입력하세요.(뒤로가기 back)>>");
			String pw = sc.nextLine();

			if (pw.equals("back")) {
				return;
			} else if (pw.equals(MyPage.me.getPw())) {
				System.out.println("정말로 탈퇴하시겠습니까? (Y/N)");
				String answer = sc.nextLine();
				if (answer.equals("Y") || answer.equals("y")) {
					ud.unRegister(MyPage.me.getId(), MyPage.me.getPw());
					MyPage.me = null;
					String[] args = null;
					Main.main(args);
				} else if (answer.equals("N") || answer.equals("n")) {
					return;
				} else {
					System.out.println("비밀번호를 다시 입력해주세요.>>");
				}
			}
		}
	}
	
}
