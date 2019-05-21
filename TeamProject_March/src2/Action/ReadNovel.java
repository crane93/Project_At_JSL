package Action;

import java.util.ArrayList;
import java.util.Scanner;

import Dao.NovelDao;
import Dto.Novel;

public class ReadNovel implements Action {

	@Override
	public void execute(Scanner sc) {
		ArrayList<Novel> list = new ArrayList<Novel>();
		Novel novel;
		int menu = 0;
		NovelDao nd = new NovelDao();

		nd.readAllNovel();
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println("==    작품 목록   ==");
			System.out.println("작품번호 + 작품명"); // 미완성
			novel = list.get(i);
			System.out.println(novel.getNovelNumber() + " : " + novel.getTitle());
		}
		System.out.println("열람하실 작품번호를 입력하시오.>>");
		int novel_number = sc.nextInt();
		list = nd.readNovel(novel_number);

		for (int i = 0; i < list.size(); i++) {
			novel = list.get(i);
			System.out.println("제목: " + novel.getTitle());
			System.out.println("조회 수: " + novel.getGetViewNumber() + "좋아요 수: " + novel.getGetLikeNumber());
			System.out.println("내용: ");
			System.out.print(novel.getLineNumber() + "  " + novel.getNickname() + "  -  " + novel.getContents());
		}

		System.out.println("1. 이어쓰기 2. 작품수정 3. 좋아요 4. 뒤로가기");
		menu = sc.nextInt();
		switch (menu) {
		case 1:
			System.out.println("40자 이내의 소설 한줄을 입력하세요");
			String novel_contents = sc.nextLine();
//			nd.addLine(novel_contents);
			this.execute(sc);
			break;
		case 2: // 2. 작품수정
			System.out.println("수정할 line_number를 입력하세요.");
			int line_number = sc.nextInt();
			System.out.println("수정하세요.>>");
			String Words = sc.next();
			// line_number, novel_number, Words
//			nd.novelUpdate(line_number, novel.getNovel_number(), Words);
			System.out.println("수정이 완료되었습니다.");
			this.execute(sc);
			break;
		case 3: // 좋아요
			System.out.println("현재 작품에 좋아요를 누르셨습니다.");
//			nd.PlusLike(novel_number); // Novel_Info_dao에 있는 PlusLike메서드 실행
//			System.out.println("현재 작품의 좋아요 갯수 : " + novel.getGet_like_number()+1);
			this.execute(sc);
			break;
		case 4: // 뒤로가기 소설목록(작품번호 + 작품명) 다시 출력
			this.execute(sc);
			break;
		default:
			System.out.println("메뉴에 선택이 올바르지 않습니다. 다시 입력해주세요>>");
		}
	}

}
