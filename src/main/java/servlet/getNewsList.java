package servlet;

import javaBean.Page;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import service.PageService;
import tools.JsonDateValueProcessor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;

@WebServlet(urlPatterns = "/servlet/getNewsList")
public class getNewsList extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Integer currentPage = Integer.valueOf(request.getParameter("currentPage"));
		String condition = request.getParameter("condition");
		PageService pageService = new PageService();
		Page page = new Page();
		page.setCondition(condition);
		page.setPage(currentPage);
		page.setTableName("news");
		page.setPageSize(6);
		page.setOrderField("newsId");
		page.setOrder("ASC");
		try {
			List newsList = pageService.getOnePageRecord(page);
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.registerJsonValueProcessor(Timestamp.class,new JsonDateValueProcessor());
			
			JSONArray jsonArray = JSONArray.fromObject(newsList,jsonConfig);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("newsList",jsonArray);
			jsonObject.put("pageInfo",page);
			HttpSession session = request.getSession();
			session.setAttribute("data",jsonObject);
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
//			dispatcher.forward(request,response);
			response.sendRedirect("/exercise/home.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
