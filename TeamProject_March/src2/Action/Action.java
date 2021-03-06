package Action;

import java.util.Scanner;

/*
 * 액션 인터페이스
 * 1. 모든 액션클래스들이 상속받을 수 있다.
 * 2. 메인에서 넘어온 입력값에 대하여 "execute"이라는 메소드가 각 클래스에서 실행된다.
 * 3. Action 패키지 내부에 있는 모든 클래스들이 이 프로젝트의 중추역할을 담당한다.
 * 4. 모든 행위, 동작, 액션, 변경 및 수정 등 사용자에 의한 모든 일들은
 * 반드시 액션 클래스를 거쳐서 세부적으로 분산된다.
 * 
 */

public interface Action { // 각각의 처리를 담당할 액션들의 조상 역할을 한다.
	
	public void execute(Scanner sc);
}
