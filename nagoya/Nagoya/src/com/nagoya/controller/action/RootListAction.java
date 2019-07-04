package com.nagoya.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagoya.DAO.rootDAO;
import com.nagoya.VO.RootVO;

public class RootListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/recommend/recommend.jsp";
		rootDAO dao = rootDAO.getInstance();
		List<RootVO> rootlist = dao.selectAllRoot();
		request.setAttribute("rootlist", rootlist);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
