package com.nagoya.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.nagoya.DAO.GurumeDAO;

public class GurumeCountAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int gnum = Integer.parseInt(request.getParameter("no"));
		GurumeDAO dao = GurumeDAO.getInstance();
		dao.updateReadCount(gnum);
		int like = dao.reCount(gnum);			//조회수 변수
		JSONObject obj = new JSONObject();
		obj.put("like", like);
		response.setContentType("application/x-json, charset=utf-8"); 
		response.getWriter().print(obj); 
	}

}
