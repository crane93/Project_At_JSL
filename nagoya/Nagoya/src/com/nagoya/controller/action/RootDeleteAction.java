package com.nagoya.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagoya.DAO.rootDAO;

public class RootDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rnum = request.getParameter("rnum");
		rootDAO dao = rootDAO.getInstance();
		dao.deleteRoot(rnum);
		new RootListAction().execute(request, response);
	}

}
