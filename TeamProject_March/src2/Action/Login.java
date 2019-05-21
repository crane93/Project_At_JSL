package Action;

import java.util.Scanner;

import Dao.UserDao;
import Dto.User;
import UserInterface.ConsoleUtils;

/*
 * 로그인 액션
 * 1. User 테이블에 존재하는 모든 회원 정보를 가져온다.
 * 2. 아이디와 비밀번호를 입력한다.
 * 3. 입력한 아이디, 비밀번호와 유저 테이블의 아이디, 비밀번호가
 * 서로 일치하는지 비교한다.
 * 4. 일치하면 로그인 성공, 로그인 이후 switch-case문을 출력한다.
 * 5. 일치하지 않으면 로그인 실패, 재입력을 시도한다. 
 * 
 */

public class Login implements Action{

	@Override
	public void execute(Scanner sc) {

		User user = null;
		UserDao ud = new UserDao();
		ConsoleUtils cu = new ConsoleUtils();
		SelectMenu sm = new SelectMenu();
		
		user = cu.login(sc);
		String pw = user.getPw();
		user = ud.login(user.getId());
		
		////////// 실패시 리턴이 Null, 실패값 우선.
		if ((user == null) || !user.getPw().equals(pw)) {
			System.out.println("비밀번호가 일치하지 않습니다");
			execute(sc);
		} else if(user.getPw().equals(pw)){
			System.out.println("비밀번호가 일치하여 로그인 성공");
			System.out.println(user.getNickname() + "님 어서오세요.");
			MyPage.me = user;
			sm.execute(sc);
		}
	}
	
}
