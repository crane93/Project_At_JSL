package Dao;

import java.util.ArrayList;

import Dto.Novel;

/*
 * 소설 테이블 dao
 * 
 * 1. 소설 정보 테이블에 접근하여 모든 변경 행위를 수행한다.
 * 2. 모든 액션, 모든 행위에 의해서 DB 내의 data가 변경될 때는 반드시,
 * 카나라즈! 이 클래스를 통과한다.
 */

public class NovelDao {
	
	DBManager mgr = new DBManager();
	ArrayList<Novel> list;
	Novel novel;
	int res = 0;
	
	public void readAllNovel() {
		list = mgr.novelList();
		if (list.isEmpty() != true) {
			System.out.println("===== 작품 목록 =====");
			System.out.println("작품번호    +   작품명"); // 미완성
			for (int i = 0; i < list.size(); i++) {
				novel = list.get(i);
				System.out.println(novel.getNovelNumber() + " : " + novel.getTitle());
			}
		} else
			System.out.println("작성된 소설이 없습니다");
	}
	
	public ArrayList<Novel> readNovel(int novelNumber) {
		list = mgr.openNovel(novelNumber);
		return list;
	}
	
	////////// 소설 조회 랭킹
	public void rankByView() {
		list = mgr.novelViewRanking3();

		System.out.println("=====소설 이름=====  =====조회수=====");
		for (int i = 0; i < list.size(); i++) {
			novel = list.get(i);

			System.out.println((i + 1) + "등>> " + novel.getTitle() + novel.getGetViewNumber());
		}
	}

	////////// 소설 좋아요 랭킹
	public void rankByLike() {
		list = mgr.novelLikeRanking3();

		System.out.println("==등수==  =====소설이름=====  =====받은 좋아요 수=====");
		for (int i = 0; i < list.size(); i++) { // 디비매니저에서 sql문 돌려서 탑3를 미리 선별
			novel = list.get(i);
			System.out.println((i + 1) + "등>>     " + novel.getTitle() + novel.getGetLikeNumber());
		}
	}

	public void writeNewNovel(Novel novel) {
		res = mgr.writeNewNovel(novel);
		if(res>0) {
			System.out.println("소설이 작성되었습니다");
		}
	}
}
