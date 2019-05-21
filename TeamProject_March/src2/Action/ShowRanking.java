package Action;

import java.util.Scanner;

import Dao.NovelDao;
import Dao.UserDao;
import UserInterface.ConsoleUtils;
import static Constant.Operation.*;

public class ShowRanking implements Action {

	@Override
	public void execute(Scanner sc) {
		NovelDao nd = new NovelDao();
		UserDao ud = new UserDao();
		ConsoleUtils cu = new ConsoleUtils();

		cu.ranking();
		int rank = sc.nextInt();

		switch (rank) {
		case RANK_BY_LIKE:
			nd.rankByLike();
			break;
		case RANK_BY_VIEW:
			nd.rankByView();
			break;
		case RANK_BY_GetMostLikeMember:
			ud.rankByGetMostLikeMember();
			break;
		case BACK:
			cu.showMenu();
			break;
		default:
			System.out.println("다시 입력해주세요");
		}
	}
	
}
