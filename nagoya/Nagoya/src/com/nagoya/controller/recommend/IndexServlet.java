package com.nagoya.controller.recommend;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagoya.DAO.GurumeDAO;
import com.nagoya.DAO.NoticeDAO;
import com.nagoya.VO.GurumeVO;
import com.nagoya.VO.NoticeVO;

@WebServlet("/index.do")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//포토폴리오 최근게시물 3개 가져오기
		GurumeDAO dao = GurumeDAO.getInstance();
		List<GurumeVO> gurumelist = dao.gurumeLatest4();
		request.setAttribute("gurumelist", gurumelist);
		NoticeDAO ndao =NoticeDAO.getInstance(); 
		List<NoticeVO> noticelist = ndao.noticeLatest5();
		request.setAttribute("noticelist", noticelist);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
}
