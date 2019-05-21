package com.nagoya.controller.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagoya.DAO.rootDAO;
import com.nagoya.VO.RootVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class RootWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		ServletContext context = request.getSession().getServletContext();			//MVC패턴에서 getServletContext()을 쓸려면 왼쪽과 같이 써야 한다고함 
		String path =  context.getRealPath("upload");
		String encType = "utf-8";
		int sizelimit = 20 * 1024 * 1024;
		MultipartRequest multi = new MultipartRequest(request, path, sizelimit, encType, new DefaultFileRenamePolicy());
		System.out.println("파일이이름 가져오기: " + multi.getFilesystemName("rimgurl"));
		//rootWrite.jsp에서 enctype="multipart/form-data"로 데이터를 가져왔기 때문에 값을 가져올때 multi.getParameter를 써야한다!
		String rtitle = multi.getParameter("rtitle");
		String rname = multi.getParameter("rname");
		String rcontent = multi.getParameter("rcontent");
		String rimgurl = multi.getFilesystemName("rimgurl");
		String rpass = multi.getParameter("rpass");
		
		RootVO vo = new RootVO();
		vo.setRtitle(rtitle);
		vo.setRname(rname);
		vo.setRcontent(rcontent);
		vo.setRimgurl(rimgurl);
		vo.setRpass(rpass);
		
		rootDAO dao = rootDAO.getInstance();
		dao.insertRoot(vo);
		new RootListAction().execute(request, response);
	}

}
