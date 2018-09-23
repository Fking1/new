package servlet;

import javaBean.User;
import service.UserService;
import tools.EmailTool;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/servlet/user")
public class user extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userService = new UserService();
		User user = new User();
		String types = request.getParameter("types");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		if(types.equals("register")){
			try {
				String mail = request.getParameter("mailAddress");
				String registerDate = String.valueOf(System.currentTimeMillis());
				user.setUserId(registerDate);
				user.setUserName(userName);
				user.setPassword(password);
				userService.register(user);
				request.setAttribute("user",user);
				EmailTool emailTool = new EmailTool();
				emailTool.sendEmail(mail,"点击完成注册","http://localhost:8080/exercise/servlet/completeRegister?userId="+registerDate);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
				dispatcher.forward(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else{
			try {
				String checkbox = request.getParameter("checkbox");
				user.setUserName(userName);
				user.setPassword(password);
				if(userService.login(user)==true){
					if(checkbox=="remember-me"){
//                        将登录态存入cookies并设置失效时间
					}
					HttpSession session = request.getSession();
					session.setAttribute("user",user);
					RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
					dispatcher.forward(request,response);
				}
				else{
//					RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
//					dispatcher.forward(request,response);
					response.sendRedirect("/exercise/login.jsp");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
}
