package Dao;

import java.util.ArrayList;

import Dto.User;

/*
 * 회원 dao
 * 1. 회원 테이블의 모든 행위는 이 클래스를 통과한다.
 * 2. DB내의 data가 변경될 때는 카나라즈 이 클래스에서 수행된다.
 * 3. 즉, 쿼리문이 실행되는 곳은 여기이다. 
 */

public class User_dao {
	public static ArrayList<User> list;
	
	public static void JoinMembership(User user) {
		
	}
	
	public static int listSize() {
		return list.size();
	}

}
