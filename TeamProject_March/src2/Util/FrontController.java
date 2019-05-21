package Util;

import java.util.Scanner;
import Action.Action;

/*
 * 프론트 컨트롤러
 * 1. 메인 클래스에서 액션 클래스의 객체와 스캐너로 입력받은 변수를 인자로 받아온다.
 * 2. 넘어온 인자를 매개변수로 액션 패키지로 넘겨준다.
 * 3. 이때, 넘어온 액션클래스의 객체는 각각의 다른 액션 클래스와 상호작용할 수 있도록
 * 		다형성적인 특징을 가지고 있다.
 * 
 */
public class FrontController {

	public void requestProcessor(Action action, Scanner sc) {
		action.execute(sc);
	}
	
}
