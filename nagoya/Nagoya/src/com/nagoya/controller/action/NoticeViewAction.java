package com.nagoya.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagoya.DAO.NoticeDAO;
import com.nagoya.VO.NoticeVO;

public class NoticeViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/helpDesk/noticeView.jsp";
		String nnum = request.getParameter("nnum");
		NoticeDAO dao = NoticeDAO.getInstance();
		NoticeVO noticelist = dao.viewNotice(nnum);
		request.setAttribute("noticelist", noticelist);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response); 
	}

}
