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


/**
 * Servlet implementation class updateUserServlet
 */
@SuppressWarnings("serial")
public class updateUserServlet extends HttpServlet {
	IUserService userService=new UserServiceImp();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("进入更新updateUserServlet,doPost方法");
		//从session里获取用户id
		User user2 = (User)request.getSession().getAttribute("user");
		int id =user2.getuId();
		String uName=user2.getuName();
		String pass = user2.getuPass();
		//创建PrintWriter对象
		PrintWriter out=response.getWriter();
		//获取修改页用户提交的信息
		String email = request.getParameter("email");//修改的邮箱
		String nickName = request.getParameter("username");//修改的昵称
		String sex = request.getParameter("sex");//修改的性别	
		String city = request.getParameter("city");//修改的城市
		String signName = request.getParameter("sign");//修改的签名
		User user = new User( id, uName, pass, sex,email, nickName, signName,city);
		boolean result=userService.updateUser(user);
		if (result) {
		    request.getSession().setAttribute("user",user);
			response.sendRedirect("front/html/user/set.jsp");
			
		}else{
			out.write(200);
		}
	}

}
