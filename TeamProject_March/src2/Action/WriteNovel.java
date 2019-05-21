package Action;

import java.util.Scanner;

import Dao.NovelDao;
import Dto.Novel;
import UserInterface.ConsoleUtils;

public class WriteNovel implements Action{

	@Override
	public void execute(Scanner sc) {
		Novel novel = null;
		NovelDao nd = new NovelDao();
		SelectMenu sm = new SelectMenu();
		ConsoleUtils cu = new ConsoleUtils(); 
		
		novel = cu.writeNovel(sc); // 소설 작성
		nd.writeNewNovel(novel); // 작성된 소설 DB 저장
		sm.execute(sc); // 다시 메뉴 출력.
	}
	
}
