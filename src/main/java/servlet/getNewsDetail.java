package servlet;

import javaBean.News;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import service.NewsService;
import tools.JsonDateValueProcessor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

@WebServlet("/servlet/getNewsDetail")
public class getNewsDetail extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        NewsService newsService = new NewsService();
        String newsId = request.getParameter("newsId");
        try {
            News news = newsService.getNewsById(Integer.valueOf(newsId));
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(Timestamp.class,new JsonDateValueProcessor());
            JSONObject jsonObject = JSONObject.fromObject(news,jsonConfig);
            HttpSession session = request.getSession();
            session.setAttribute("newsDetail",jsonObject);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/newsDetail.jsp");
            dispatcher.forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
