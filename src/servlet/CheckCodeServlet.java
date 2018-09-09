package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class CheckCodeServlet extends HttpServlet{
    //验证输入框验证码输入是否正确
	@Override
	   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 // 获取PrintWriter对象
		PrintWriter out = resp.getWriter();
		// 获取用户输入的验证码
		String checkCode = req.getParameter("checkCode");
		//System.out.println("获取到输入的验证码是:"+checkCode);
		String sessionCode = (String) req.getSession().getAttribute("checkCode");
		// 判断用户输入的验证码是否正确
		if (checkCode != null && checkCode.equalsIgnoreCase(sessionCode)) {
			out.write("100");
			
		} else {
			out.write("200");
			resp.sendRedirect("/ForumProject/front/html/user/login.jsp");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
}
