package com.nagoya.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagoya.DAO.rootDAO;
import com.nagoya.VO.RootVO;

public class RootModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/recommend/rootUpdate.jsp";
		String rnum = request.getParameter("rnum");
		System.out.println(rnum);
		rootDAO dao = rootDAO.getInstance();
		RootVO vo = dao.viewRoot(rnum);
		request.setAttribute("vo", vo);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response); 
	}

}
