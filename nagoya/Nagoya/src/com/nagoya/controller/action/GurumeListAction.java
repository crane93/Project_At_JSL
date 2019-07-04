package com.nagoya.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagoya.DAO.GurumeDAO;
import com.nagoya.VO.GurumeVO;

public class GurumeListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/recommend/gurumeList.jsp";
		GurumeDAO dao = GurumeDAO.getInstance();
		List<GurumeVO> gurumelist = dao.selectAllGurume();
		request.setAttribute("gurumelist", gurumelist);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response); 
	}

}
