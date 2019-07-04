package com.nagoya.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagoya.DAO.NoticeDAO;
import com.nagoya.VO.NoticeVO;

public class NoticeWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ntitle = request.getParameter("ntitle");
		String nname = request.getParameter("nname");
		String ncontent = request.getParameter("ncontent");
		String npass = request.getParameter("npass");
		
		NoticeVO vo = new NoticeVO();
		vo.setNcontent(ncontent);
		vo.setNname(nname);
		vo.setNpass(npass);
		vo.setNtitle(ntitle);
		
		NoticeDAO dao = NoticeDAO.getInstance();
		dao.insertNotice(vo);
		 
		new NoticeListAction().execute(request, response);
	}
}
