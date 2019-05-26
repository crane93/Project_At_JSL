package com.nagoya.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagoya.DAO.NoticeDAO;

public class NoticeDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nnum = request.getParameter("nnum");
		NoticeDAO dao = NoticeDAO.getInstance();
		dao.deleteNotice(nnum);
		new NoticeListAction().execute(request, response); 
	}

}
