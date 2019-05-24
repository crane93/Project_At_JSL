package com.nagoya.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	 * 루트리스트에서 클릭한 게시글을 찾는 메소드
	 * @param rnum
	 * @return rnum에 해당하는 게시글의 컬럼들
	 */
	public RootVO viewRoot(String rnum) {
		String sql = "select * from osusumeroot where rnum = ?";
		RootVO vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnention();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rnum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new RootVO();
				vo.setRnum(rs.getInt("rnum"));
				vo.setRcontent(rs.getString("rcontent"));
				vo.setRimgurl(rs.getString("rimgurl"));
				vo.setRname(rs.getString("rname"));
				vo.setRpass(rs.getString("rpass"));
				vo.setRreadcount(rs.getInt("rreadcount"));
				vo.setRtitle(rs.getString("rtitle"));
				vo.setRwritedate(rs.getTimestamp("rwritedate"));
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
	 * @param rnum
	 */
	public void deleteRoot(String rnum) {
		String sql = "delete from osusumeroot where rnum = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnention();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rnum);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	/**
	 * 게시글을 수정하는 메소드
	 * @param rnum
	 */
	public void updateRoot(RootVO vo) {
		String sql = "update osusumeroot set rtitle = ?, rname = ?, rcontent = ?, rimgurl = ?, rpass = ? where rnum = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnention();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getRtitle());
			pstmt.setString(2, vo.getRname());
			pstmt.setString(3, vo.getRcontent());
			pstmt.setString(4, vo.getRimgurl());
			pstmt.setString(5, vo.getRpass());
			pstmt.setInt(6, vo.getRnum());
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
	public boolean checkPass(int rnum, String rname) {
		String sql = "select * from osusumeroot where rnum = ? and rname = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean check = false;
		try {
			conn = DBManager.getConnention();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rnum);
			pstmt.setString(2, rname);
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
}
