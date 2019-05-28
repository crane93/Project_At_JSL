package com.nagoya.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagoya.DAO.NoticeDAO;
import com.nagoya.VO.NoticeVO;

public class NoticeListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String url = "/helpDesk/noticeList.jsp";
//		NoticeDAO dao = NoticeDAO.getInstance();
//		List<NoticeVO>  noticelist = dao.selectAllNotice();
//		Paging paging = new Paging();
//		
//		request.setAttribute("noticelist", noticelist);
//		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
//		dispatcher.forward(request, response);
		
		NoticeDAO nDao = NoticeDAO.getInstance();
	    String url = "HelpDeskServlet?command=notice_list";
	      
	    if(request.getParameter("search") == null) {
	    String s_query = "", addtag="", query = "", key = "";
	    int nowpage = 1;  
	    int maxlist = 3;                       // 한페이지에 출력할 글수 설정
	    int totpage = 1;
	    int totcount = nDao.selectAllcount();
	    
	    if (totcount % maxlist == 0)             // 총 글수로 총 페이지 계산
	       totpage = totcount / maxlist;
	    else
	       totpage = totcount / maxlist + 1;
	    
	    if(totpage == 0) totpage = 1;            // 총 페이지수가 0이면 1로 초기화
	    
	    if(request.getParameter("page") != null && !request.getParameter("page").equals(""))  // 현재페이지를 받음
	       nowpage = Integer.parseInt(request.getParameter("page"));
	    if(nowpage > totpage)  // 현재페이지가 총페이지보다 클때 마지막 페이지로 변환
	    	nowpage = totpage;
	
	    int pagestart = (nowpage - 1) * maxlist + 1; // 현재페이지 시작번호 구하기
	    int endpage = nowpage * maxlist; // 30 이 될 겁니다. 
	    int listcount = totcount - ((nowpage -1) * maxlist) +1;
        List<NoticeVO> list = nDao.boardList(pagestart, endpage);//검색없음
	      
	      //System.out.print(list.size());
	      
	    request.setAttribute("addtag", addtag);
	    request.setAttribute("url", url);
	    request.setAttribute("nowpage", nowpage);
	    request.setAttribute("totpage", totpage);
	    request.setAttribute("totalcount", totcount);
	    request.setAttribute("pagestart", pagestart);
	    request.setAttribute("listcount", listcount);
	    request.setAttribute("noticelist", list);
	    request.setAttribute("maxlist", maxlist);
	    }
	      
	      
//	      else {
//	      String s_query = "", addtag = "", query = "", search = "";
//	      
//	      if (request.getParameter("search") != null && !request.getParameter("search").equals("")) {
//	
//	         query = request.getParameter("sel");//제목이냐 내용이냐
//	         search = request.getParameter("search");
//	         // s_query = " where " + query + " like '%" + key + "%'";
//	         s_query = query + " like '%" + search + "%'";
//	         addtag = "&sel=" + query + "&search=" + search;
//	      }
//	      // System.out.println(query);
//	      // System.out.println(search);
//	      int nowpage = 1;
//	      int maxlist = 3; // 한페이지에 출력할 글수 설정
//	      int totpage = 1;
//	      int totcount = nDao.selectAllcount(s_query);
//	      if (totcount % maxlist == 0) // 총 글수로 총 페이지 계산
//	         totpage = totcount / maxlist;
//	      else
//	         totpage = totcount / maxlist + 1;
//	      if (totpage == 0)
//	         totpage = 1; // 총 페이지수가 0이면 1로 초기화
//	      if (request.getParameter("page") != null && !request.getParameter("page").equals("")) 
//	         // 현재페이지를 받음
//	         nowpage = Integer.parseInt(request.getParameter("page"));
//	      if (nowpage > totpage) // 현재페이지가 총페이지보다 클때 마지막 페이지로 변환
//	         nowpage = totpage;
//	
//	      int pagestart = (nowpage - 1) * maxlist + 1; // 현재페이지 시작번호 구하기
//	      int endpage = nowpage * maxlist; // 30 이 될 겁니다.
//	      int listcount = totcount - ((nowpage - 1) * maxlist) + 1;
//	      List<NoticeVO> list = nDao.boardList(s_query, pagestart, endpage);// 검색없음
//	      
//	      request.setAttribute("addtag", addtag);
//	      request.setAttribute("url", url);
//	      request.setAttribute("nowpage", nowpage);
//	      request.setAttribute("totpage", totpage);
//	      request.setAttribute("totalcount", totcount);
//	      request.setAttribute("pagestart", pagestart);
//	      request.setAttribute("listcount", listcount);
//	      request.setAttribute("noticelist", list);
//	      request.setAttribute("query", query);
//	      request.setAttribute("search", search);
//	      request.setAttribute("maxlist", maxlist);
//	      }
	
	      RequestDispatcher dispatcher = request.getRequestDispatcher("/helpDesk/noticeList.jsp");
	      dispatcher.forward(request, response);
	}
}