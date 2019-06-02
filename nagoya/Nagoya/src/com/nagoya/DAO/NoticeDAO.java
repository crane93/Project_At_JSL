package com.nagoya.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nagoya.VO.NoticeVO;
import com.nagoya.VO.RootVO;

import util.DBManager;

public class NoticeDAO {
	private NoticeDAO() {}
	private static NoticeDAO instance = new NoticeDAO();
	public static NoticeDAO getInstance() {
		return instance;
	}
	
	/**
	 * 글쓰기의 내용을 DB에 적용하는 메소드
	 * @param NoticeVo객체
	 */
	public void insertNotice(NoticeVO vo) {
		String sql = "insert into helpNotice (nnum, nname, npass, ntitle, ncontent) values(helpNotice_seq.nextval,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnention();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getNname());
			pstmt.setString(2, vo.getNpass());
			pstmt.setString(3, vo.getNtitle());
			pstmt.setString(4, vo.getNcontent());
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	/**
	 * 공지사항게시판의 글 목록을 보여주기위한 메소드 
	 * @return 게시글 전부
	 */
	public List<NoticeVO> selectAllNotice(){
		String sql = "select * from helpNotice order by nnum desc";
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnention();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NoticeVO vo = new NoticeVO();
				vo.setNnum(rs.getInt("nnum"));
				vo.setNtitle(rs.getString("ntitle"));
				vo.setNname(rs.getString("nname"));
				vo.setNwritedate(rs.getTimestamp("nwritedate"));
				vo.setNcontent(rs.getString("ncontent"));
				vo.setNpass(rs.getString("npass"));
				list.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	/**
	 * 공지사항리스트에서 클릭한 게시글을 찾는 메소드
	 * @param nnum
	 * @return nnum에 해당하는 게시글의 컬럼들
	 */
	public NoticeVO viewNotice(String nnum) {
		String sql = "select * from helpNotice where nnum = ?";
		NoticeVO vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnention();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nnum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new NoticeVO();
				vo.setNnum(rs.getInt("nnum"));
				vo.setNcontent(rs.getString("ncontent"));
				vo.setNname(rs.getString("nname"));
				vo.setNpass(rs.getString("npass"));
				vo.setNtitle(rs.getString("ntitle"));
				vo.setNwritedate(rs.getTimestamp("nwritedate"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return vo;
	}
	
	/**
	 * 게시글삭제메소드
	 * @param nnum
	 */
	public void deleteNotice(String nnum) {
		String sql = "delete from helpNotice where nnum = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnention();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nnum);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	/**
	 * 게시글을 수정하는 메소드
	 */
	public void updateNotice(NoticeVO vo) {
		String sql = "update helpNotice set ntitle = ?, nname = ?, ncontent = ? where nnum = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnention();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getNtitle());
			pstmt.setString(2, vo.getNname());
			pstmt.setString(3, vo.getNcontent());
			pstmt.setInt(4, vo.getNnum());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	/**
	 * 게시글 수정에서 글작성시 입력한 비밀번호와 일치하는지 검사하는 메소드
	 */
	public boolean checkPass(String nnum, String npass) {
		String sql = "select * from helpNotice where Nnum = ? and npass= ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean check = false;
		try {
			conn = DBManager.getConnention();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nnum);
			pstmt.setString(2, npass);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				check = true;
			}else {
				check = false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return check;
	}
	
	/**
	 * 최신 공지사항 5개 가져오는 메소드
	 * @return
	 */
	public List<NoticeVO> noticeLatest5() {
		String sql = "SELECT * FROM (SELECT * FROM helpNotice ORDER BY nwritedate desc) where rownum < 6";
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnention();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NoticeVO vo = new NoticeVO();
				vo.setNnum(rs.getInt("nnum"));
				vo.setNtitle(rs.getString("ntitle"));
				vo.setNname(rs.getString("nname"));
				vo.setNwritedate(rs.getTimestamp("nwritedate"));
				vo.setNcontent(rs.getString("ncontent"));
				vo.setNpass(rs.getString("npass"));
				list.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs); 
		}
		return list;
	}
	
	/**
	 * 공지사항의 게시글 갯수를 반환하는 메소드
	 */
	public int getHowManyNotice() {
		int total = 0;
		String sql = "select count(*) from helpNotice";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnention();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				total = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs); 
		}
		return total;
	}
	
	/**
	 * 검색창에 입력한 단어가 포함된 포트폴리오의 갯수를 출력
	 * 
	 * @param s_query
	 * @return count: 레코드갯수
	 */
	public int selectAllcount(String s_query) {
		int count = 0;
		String sql = "select count(*) from helpNotice";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		int row = 0;

		try {
			conn = DBManager.getConnention();
			if (s_query.equals("")) {
				query = "select count(*) as counter from helpNotice ";
			} else {
				query = "select count(*) as counter from helpNotice where " + s_query;
			}

			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			// rs.last();
			// count = rs.getRow();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return count;
	} // end selectAllcount(String)

	public int selectAllcount() {
		int count = 0;
		String sql = "select count(*) from helpNotice";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		int row = 0;

		try {
			conn = DBManager.getConnention();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			// rs.last();
			// count = rs.getRow();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return count;
	}

	/**
	 * 
	 * @param s_query
	 * @param pagestart
	 * @param endpage
	 * @return
	 */
	public List<NoticeVO> boardList(String s_query, int pagestart, int endpage) {
		// 검색조건이 있을때 (s_quqery)
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		List<NoticeVO> list = new ArrayList<NoticeVO>();

		try {
			conn = DBManager.getConnention();
			query = "select X.* from (select rownum as rnum, A.* from "
					+ "(select * from helpNotice order by nwritedate desc) A where " + s_query + // ()안의 select문을 A에 저장해라
					" and rownum <= ?) X where " + s_query + " and X.rnum >= ?";
			// x, a, x 가상테이블이라고 생각하고 생각하자
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, pagestart);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				NoticeVO nVo = new NoticeVO();
				nVo.setNnum(rs.getInt("nnum"));
				nVo.setNpass(rs.getString("npass"));
				nVo.setNname(rs.getString("nname"));
				nVo.setNtitle(rs.getString("ntitle"));
				nVo.setNcontent(rs.getString("ncontent"));
				nVo.setNwritedate(rs.getTimestamp("nwritedate"));
				list.add(nVo);
				System.out.println(nVo.getNname());
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	
	public List<NoticeVO> boardList(int pagestart, int endpage) {
		// 검색조건이 없을때 (s_quqery)
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		List<NoticeVO> list = new ArrayList<NoticeVO>();

		try {
			conn = DBManager.getConnention();
			query = "select X.* from (select rownum as rnum, A.* from (select * from helpNotice order by nnum desc) A where rownum <= ?) X where X.rnum >= ?";
			// x, a, x 가상테이블이라고 생각하고 생각하자

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, pagestart);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				NoticeVO nVo = new NoticeVO();
				nVo.setNnum(rs.getInt("nnum"));
				nVo.setNpass(rs.getString("npass"));
				nVo.setNname(rs.getString("nname"));
				nVo.setNtitle(rs.getString("ntitle"));
				nVo.setNcontent(rs.getString("ncontent"));
				nVo.setNwritedate(rs.getTimestamp("nwritedate"));
				list.add(nVo);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	public NoticeVO prenextByCodeP(String code) { // 데이터베이스에 저장하는거니까 출력형식은 포트폴리오vo이다
		String sql = "select nnum, ntitle from helpNotice where nnum=(select max(nnum) from helpNotice where nnum < ?)";
		NoticeVO nVop = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnention();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				nVop = new NoticeVO();
				nVop.setPreseq(rs.getInt("nnum"));
				nVop.setNtitle(rs.getString("ntitle"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return nVop;
	}

	public NoticeVO prenextByCodeN(String code) { // 데이터베이스에 저장하는거니까 출력형식은 포트폴리오vo이다
		String sql = "select nnum, ntitle from helpNotice where nnum=(select min(nnum) from helpNotice where nnum > ?)";
		NoticeVO nVon = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnention();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				nVon = new NoticeVO();
				nVon.setAfterseq(rs.getInt("nnum"));
				nVon.setNtitle(rs.getString("ntitle"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return nVon;
	}
}
