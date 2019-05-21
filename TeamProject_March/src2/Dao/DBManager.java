package Dao;

import java.util.ArrayList;
import java.sql.*;

import Dto.User;
import Dto.Novel;

public class DBManager {
	DBCon conn;

	public DBManager() {
		conn = new DBCon();
	}

	////////// 회원가입
	public int joinUser(User user) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int res = 0;
		String sql = "insert into user values (?, ?, ?, '하수', 0, 0, ?)";
		try {
			con = conn.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPw());
			pstmt.setString(3, user.getNickname());
			pstmt.setString(4, user.getAnswerForPw());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}

	////////// 로그인
	public User login(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from user where id=?";
		User user = null;

		try {
			con = conn.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new User(rs.getString("id"), rs.getString("pw"), rs.getString("nickname"), rs.getString("grade"),
						rs.getInt("count_mynovel"), rs.getInt("count_like"), rs.getString("answer_for_pw"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	////////// 패스워드 찾기
	public String findPassword(String id, String pwAnswer) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from user where id = ? and answer_for_pw = ?";
		String pw = null;

		try {
			con = conn.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwAnswer);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				pw = rs.getString("pw");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return pw;
	}

	////////// 소설 작성
	public int writeNewNovel(Novel novel) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int res = 0;
		String sql = "insert into novel_info select 1, ?, ?, ?, ifnull(max(novel_number)+1, 0), 0, 0 from novel_info";

		try {
			con = conn.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, novel.getTitle());
			pstmt.setString(2, novel.getContents());
			pstmt.setString(3, novel.getId());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}

	////////// 회원 탈퇴
	public int unRegister(String id, String pw) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "delete from user where id = ? and pw = ?";
		int res = 0;

		try {
			con = conn.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}

	////////// 조회수 증가
	public void plusView(int novelNumber) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "update novel_info set get_view_number = get_view_number + 1 where novel_number = ?";
		try {
			con = conn.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, novelNumber);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	////////// 소설 열람
	public ArrayList<Novel> openNovel(int novelNumber) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Novel> list = new ArrayList<Novel>();

		String sql = "select * from novel where novel_number = ?";
		try {

//			plusView(novelNumber);
			con = conn.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, novelNumber);
//			pstmt.executeQuery();

//			sql = "select * from user inner join novel_info on user.id = novel_info.id where novel_number = ?";
//			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Novel(rs.getInt("novel_number"), rs.getInt("line_number"), rs.getString("novel_name"),
						rs.getString("novel_contents"), rs.getString("id"), rs.getInt("get_like_number"),
						rs.getInt("get_view_number")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	////////// 소설 목록
	public ArrayList<Novel> novelList() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Novel> list = new ArrayList<Novel>();
		String sql = "select distinct(novel_number), novel_name from novel order by novel_number";

		try {
			con = conn.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Novel(rs.getInt("novel_number"), rs.getString("novel_name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
//				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	////////// 소설 조회 랭킹
	public ArrayList<Novel> novelViewRanking3() {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "select distinct * from novel_info order by get_view_number desc limit 3";
		ResultSet rs = null;
		ArrayList<Novel> list = new ArrayList<Novel>();

		try {
			con = conn.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Novel(rs.getInt("novel_number"), rs.getString("novel_name"), rs.getInt("get_like_number"),
						rs.getInt("get_view_number")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	////////// 소설 좋아요 랭킹
	public ArrayList<Novel> novelLikeRanking3() {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "select distinct * from novel_info order by get_like_number desc limit 3";
		ResultSet rs = null;
		ArrayList<Novel> list = new ArrayList<Novel>();

		try {
			con = conn.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Novel(rs.getInt("novel_number"), rs.getString("novel_name"), rs.getInt("get_like_number"),
						rs.getInt("get_view_number")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	////////// 유저 좋아요 랭킹
	public ArrayList<User> userRanking() {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "select distinct * from user order by count_like desc limit 3";
		ResultSet rs = null;
		ArrayList<User> list = new ArrayList<User>();

		try {
			con = conn.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new User(rs.getString("nickname"), rs.getString("grade"), rs.getInt("count_like")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	////////// 유저 닉네임 수정
	public int modiNickname(String id, String newNickname) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "update user set nickname = ? where id = ?";
		ResultSet rs = null;
		int res = 0;

		try {
			con = conn.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newNickname);
			pstmt.setString(2, id);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}

	////////// 유저 패스워드 수정
	public int modiPw(String id, String newPw) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "update user set pw = ? where id = ?";
		int res = 0;

		try {
			con = conn.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newPw);
			pstmt.setString(2, id);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}
}