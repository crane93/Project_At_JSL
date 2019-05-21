package com.nagoya.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.nagoya.VO.RootVO;

import util.DBManager;

public class rootDAO {
	private rootDAO() {}
	private static rootDAO instance = new rootDAO();
	public static rootDAO getInstance() {
		return instance;
	}
	
	/**
	 * 글쓰기의 내용을 DB에 적용하는 메소드
	 * @param RootVo객체
	 */
	public void insertRoot(RootVO vo) {
		String sql = "insert into osusumeRoot (rnum, rname, rpass, rtitle, rcontent, rimgurl) values(osusumeRoot_seq.nextval,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnention();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getRname());
			pstmt.setString(2, vo.getRpass());
			pstmt.setString(3, vo.getRtitle());
			pstmt.setString(4, vo.getRcontent());
			pstmt.setString(5, vo.getRimgurl());
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	/**
	 * 루트추천게시판의 글 목록을 보여주기위한 메소드 
	 * @return 게시글 전부
	 */
	public List<RootVO> selectAllRoot(){
		String sql = "select * from osusumeroot order by rnum desc";
		List<RootVO> list = new ArrayList<RootVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnention();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				RootVO vo = new RootVO();
				vo.setRnum(rs.getInt("rnum"));
				vo.setRtitle(rs.getString("rtitle"));
				vo.setRname(rs.getString("rname"));
				vo.setRreadcount(rs.getInt("rreadcount"));
				vo.setRwritedate(rs.getTimestamp("rwritedate"));
				vo.setRimgurl(rs.getString("rimgurl"));
				vo.setRcontent(rs.getString("rcontent"));
				vo.setRpass(rs.getString("rpass"));
				list.add(vo);
			}
		}catch(Exception e) {
			
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
}
