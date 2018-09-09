package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import bean.User;
import service.imp.SignServiceImp;

public class SignServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String flag = req.getParameter("flag");
		PrintWriter out =resp.getWriter();
		User user=(User)req.getSession().getAttribute("user");
		SignServiceImp service=new SignServiceImp();
		if("qiandao".equals(flag)){
			
			boolean sign=service.isSign(user.getuId());
			
			//创建PrintWriter 对象
			if(sign){      //签到成功
				out.write("100");
			}else{			//已经签到
				out.write("200");
				}
		}else if("tianshu".equals(flag)){
		
		int times=service.showSignTimes(user.getuId());
		
		Gson gson = new Gson();
		String str = gson.toJson(times);
		out.write(str);
		}
		
	}
}
