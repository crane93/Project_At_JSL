package Dao;

import java.util.ArrayList;
import java.util.Scanner;

import Action.MyPage;
import Dto.User;

/*
 * 회원 dao
 * 1. 회원 테이블의 모든 행위는 이 클래스를 통과한다.
 * 2. DB내의 data가 변경될 때는 카나라즈 이 클래스에서 수행된다.
 * 3. 즉, 쿼리문이 실행되는 곳은 여기이다. 
 */

public class UserDao {

	DBManager mgr = new DBManager();
	ArrayList<User> list;
	User user;

	public boolean joinMembership(User user) {
		int res = 0;
		res = mgr.joinUser(user);

		if (res > 0) {
			return true;
		} else {
			return false;
		}
	}

	public User login(String id) {
		User user = mgr.login(id);
		return user;
	}

	public String findPassword(String id, String pwAnswer) {
		String pw = mgr.findPassword(id, pwAnswer);
		return pw;
	}

	public void modiNickname(Scanner sc) { // 닉네임 수정
		String newNickname;
		String checkPw;

		System.out.print("비밀번호를 입력하세요>> ");
		checkPw = sc.nextLine();
		int res = 0;

		if (MyPage.me.getPw().equals(checkPw) != false) {
			System.out.println("새로운 닉네임을 입력하세요 >>");
			newNickname = sc.nextLine();

			res = mgr.modiNickname(MyPage.me.getId(), newNickname);
			if (res > 0) {
				MyPage.me.setNickname(newNickname);
				System.out.println(MyPage.me.getNickname() + "로 닉네임변경 완료");
			}
//			return;
		} else {
			System.out.println("비밀번호를 잘못입력했습니다");
			this.modiNickname(sc);
		}
	}

	public void modiPw(Scanner sc) { // 비번수정
		String newPw;
		String checkPw;
		int res = 0;

		System.out.println("비밀번호를 입력하세요>>");
		checkPw = sc.nextLine();

		if (MyPage.me.getPw().equals(checkPw) != false) {
			System.out.println("새로운 비밀번호를 입력하세요 >>");
			newPw = sc.nextLine();
			res = mgr.modiPw(MyPage.me.getId(), newPw);
			if (res > 0) {
				MyPage.me.setPw(newPw);
				System.out.println("비밀번호 변경완료");
			}
//			mmd.execute(sc); // 내정보 수정으로 이동
		} else {
			System.out.println("비밀번호를 잘못입력했습니다");
			this.modiNickname(sc);
		}
	}
	
	public void unRegister(String id, String pw) {
		int res = mgr.unRegister(id, pw);
		if(res > 0) {
			System.out.println("정상적으로 탈퇴되었습니다.");
		}
	}

	public void rankByGetMostLikeMember() {
		list = mgr.userRanking();
		System.out.println("===== 회원 닉네임 =====  ===== 좋아요 수 =====");
		for (int i = 0; i < list.size(); i++) {
			user = list.get(i);
			System.out.println((i + 1) + "등>> " + user.getNickname() + user.getCountLike());
		}
	}
}
