package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import service.IUserService;
import service.imp.UserServiceImp;

public class RegServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IUserService ius = new UserServiceImp();
		int result =-1;
		String name = req.getParameter("uName");
		String pass = req.getParameter("pass");
		String repass = req.getParameter("repass");
		
		PrintWriter out= resp.getWriter();
			if (ius.isMatch(name)) {
				//不能注册
				resp.sendRedirect("front/html/user/reg.jsp");
			}else {
				ius.insertUser(new User(name,pass));
				resp.sendRedirect("front/html/user/login.jsp");
			
		}
	}
}
