package Action;

import java.util.Scanner;
<<<<<<< HEAD:RelayNovelProject/src/Action/Membership.java
=======

import Dao.UserDao;
>>>>>>> 088ed14838f1df2980ab7857432ee058d872e4fc:src2/Action/Membership.java
import Dto.User;
import UserInterface.ConsoleUtils;

/*
 * 회원가입 액션
 * 
 * 1. 회원가입에 관련된 중앙 관제탑 역할
 * 2. 이 클래스는 MembershipSVC과 연계하여 회원가입 과정을 진행시킨다.
 * 3. 그 과정에서 DB내의 회원에 관련된 정보를 Dto 패키지의 User클래스로부터
 * 얻어온다.
 * 4. 완성된 회원 객체의 정보를 Dao 패키지의 User로 날려보내면 거기서 DB가
 * 최종 수정이 된다.
 */

<<<<<<< HEAD:RelayNovelProject/src/Action/Membership.java
public class Membership implements Action{
=======
public class Membership implements Action {
>>>>>>> 088ed14838f1df2980ab7857432ee058d872e4fc:src2/Action/Membership.java

	@Override
	public void execute(Scanner sc) {
		User user = null;
		UserDao ud = new UserDao();
		boolean tf = false;
		ConsoleUtils cu = new ConsoleUtils();
		user = cu.joinMembership(sc);
		
<<<<<<< HEAD:RelayNovelProject/src/Action/Membership.java
		
		user = cu.JoinMembership(sc);
	
		int size = svc.Join(user); // dao를 통해 회원가입을 완료시킨다. DB갱신 발생.
=======
		tf = ud.joinMembership(user);
>>>>>>> 088ed14838f1df2980ab7857432ee058d872e4fc:src2/Action/Membership.java
		
		if(tf == true) {
			cu.joinSuccess(user);
		}else {
			cu.joinFail();
		}
	}
	
}
