package com.nagoya.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagoya.DAO.rootDAO;
import com.nagoya.VO.RootVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class RootUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		ServletContext context = request.getSession().getServletContext();			//MVC패턴에서 getServletContext()을 쓸려면 왼쪽과 같이 써야 한다고함 
		String path =  context.getRealPath("upload");
		String encType = "utf-8";
		int sizelimit = 20 * 1024 * 1024;
		MultipartRequest multi = new MultipartRequest(request, path, sizelimit, encType, new DefaultFileRenamePolicy());
		
		int rnum = Integer.parseUnsignedInt(multi.getParameter("rnum"));
		String rtitle = multi.getParameter("rtitle");
		String rname = multi.getParameter("rname");
		String rcontent = multi.getParameter("rcontent");
		String rimgurl = multi.getFilesystemName("rimgurl");
		String rpass = multi.getParameter("rpass");
	
		RootVO vo = new RootVO();
		vo.setRnum(rnum);
		vo.setRtitle(rtitle);
		vo.setRname(rname);
		vo.setRcontent(rcontent);
		vo.setRimgurl(rimgurl);
		vo.setRpass(rpass);
		
		rootDAO dao = rootDAO.getInstance();
		boolean check = dao.checkPass(rnum, rpass);
		System.out.println(check);
		if(check) {
			dao.updateRoot(vo);
			new RootListAction().execute(request, response);
		}else {
			request.setAttribute("message", "비밀번호가 일치하지 않습니다");
			String url = "RecommendRootServlet?command=root_modify&rnum"+rnum;
			System.out.println(url);
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
		
	}

}
