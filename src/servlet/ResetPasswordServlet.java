package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.User;
import service.IUserService;
import service.imp.UserServiceImp;

/**
 * Servlet implementation class ResetPasswordServlet
 */

@SuppressWarnings("serial")
public class ResetPasswordServlet extends HttpServlet {
	IUserService userService=new UserServiceImp();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("欢迎进入修改密码方法");
		//从session里获取登录密码
		User user2 = (User)request.getSession().getAttribute("user");
		
		int id =user2.getuId();
		String pass=user2.getuPass();
		//获取输入的密码
		String nowPass=request.getParameter("nowpass");
		String newPass=request.getParameter("pass");
		
		//System.out.println("获取到的id,密码以及新密码分别是："+id+" , "+pass+" , "+nowPass+","+newPass);
		if(pass.equals(nowPass)){
		boolean	result=userService.setPassById(id,newPass);
		if(result){
			//System.out.println("密码设置成功");
			response.sendRedirect("front/html/user/set.jsp");
		}else{
			//System.out.println("密码设置失败");
		}
		}else{
			response.sendRedirect("front/html/user/set.jsp");
		}
	}
}
