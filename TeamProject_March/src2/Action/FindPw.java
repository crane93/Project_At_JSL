package Action;

import java.util.Scanner;

import Dao.UserDao;
import Dto.User;
import UserInterface.ConsoleUtils;

public class FindPw implements Action {

	@Override
	public void execute(Scanner sc) {
		UserDao ud = new UserDao();
		User user;
		ConsoleUtils cu = new ConsoleUtils();

		user = cu.findPw(sc); // id , answer만 들어있는 객체
		String pw = ud.findPassword(user.getId(), user.getAnswerForPw());
		System.out.println("패스워드 : " + pw);
	}
}
