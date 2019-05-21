package Service;

import Dto.User;
import static Dao.User_dao.*;
/*
 * 회원가입 서비스 클래스
 * 
 * 1. 회원가입 액션 클래스의 기능들을 묶어놓은 서비스 계층
 * 2. 스스로 어떠한 행위를 결정지을 수 없고 단순히 기능들만을 모아놓은 곳.
 * 3. 즉, 액션 클래스들이 중추역할을 하기 위해서 손과 발이 되어주는 곳이다.
 * 
 */
public class MembershipSVC {

	public int Join(User user) {
		JoinMembership(user);
		int size = listSize();
		return size;
	}

}
