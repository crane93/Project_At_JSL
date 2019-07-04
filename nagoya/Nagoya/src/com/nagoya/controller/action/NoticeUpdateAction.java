package com.nagoya.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagoya.DAO.NoticeDAO;
import com.nagoya.VO.NoticeVO;

public class NoticeUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ntitle = request.getParameter("ntitle");
		String nname = request.getParameter("nname");
		String ncontent = request.getParameter("ncontent");
		String npass = request.getParameter("npass");
		String nnum = request.getParameter("nnum");
		NoticeVO vo = new NoticeVO();
		vo.setNcontent(ncontent);
		vo.setNname(nname);
		vo.setNpass(npass);
		vo.setNtitle(ntitle);
		vo.setNnum(Integer.parseInt(nnum));
		
		NoticeDAO dao = NoticeDAO.getInstance();
		
		boolean check = dao.checkPass(nnum, npass);
		if(check) {
			dao.updateNotice(vo);
			new NoticeListAction().execute(request, response);
		}else {
			request.setAttribute("message", "비밀번호가 일치하지 않습니다");
			String url = "HelpDeskServlet?command=notice_modify&nnum"+nnum;
			System.out.println(url);
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
	}
}
