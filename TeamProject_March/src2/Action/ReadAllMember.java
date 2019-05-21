package Action;

import static Constant.Operation.*;
import java.util.Scanner;

import Dao.NovelDao;
import UserInterface.Main;

public class ReadAllMember implements Action{

	@Override
	public void execute(Scanner sc) {
		NovelDao nd = new NovelDao();
		int novelNumber = 0;
		int menu = 0;
		nd.readAllNovel();
		System.out.println("읽으려는 소설번호를 입력하세요>>");
		novelNumber = sc.nextInt();
		nd.readNovel(novelNumber);	
		System.out.println();
		System.out.println("읽어주셔서 감사합니다.");
		System.out.print("1:목록으로 돌아가기  0:나가기  >>");
		System.out.println();
		menu = Integer.parseInt(sc.nextLine());
		
		switch(menu) {
		case BACK_LIST:	//소설 목록으로 돌아감
			this.execute(sc);
			break;
		case HOME:		//메인으로 돌아감
			String[] args = null;
			Main.main(args);
			break;
		default:
			System.out.println("잘못입력하셨습니다."); 
		}
	}
}
