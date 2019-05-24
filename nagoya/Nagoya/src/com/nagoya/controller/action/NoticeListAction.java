package com.nagoya.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagoya.DAO.NoticeDAO;
import com.nagoya.VO.NoticeVO;

public class NoticeListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/helpDesk/noticeList.jsp";
		NoticeDAO dao = NoticeDAO.getInstance();
		List<NoticeVO>  noticelist = dao.selectAllNotice();
		request.setAttribute("noticelist", noticelist);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
