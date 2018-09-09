package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import service.IUserService;
import service.imp.UserServiceImp;

public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IUserService ius = new UserServiceImp();
		String name = req.getParameter("uname");
		String pass = req.getParameter("pass");
		User user = ius.getUserByNameAndPass(name, pass);
		//获取用户登录的角色  
		int rId=ius.userLoginByRole(name);
		//如果user对象不为空，将用户名和密码放入session
		if (user!=null&&!"".equals(user.getuName())&&!"".equals(user.getuPass())) {
			req.getSession().setAttribute("user",user);
			if(rId==2) {
				//System.out.println("你是系统管理员");
				resp.sendRedirect("back/index.html");
			}else{
				//System.out.println("你是普通用户");
				//System.out.println(user.getuId());
				req.getRequestDispatcher("front/html/jie/shouye.jsp").forward(req, resp);
			}
		}else {
				resp.sendRedirect("front/html/user/login.jsp");
			}
	}
}
