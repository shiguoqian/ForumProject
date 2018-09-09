package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import bean.Message;
import bean.Post;
import bean.User;
import service.IPostService;
import service.IUserService;
import service.imp.PostServiceImp;
import service.imp.UserServiceImp;

public class ShowAllServlet extends HttpServlet{
	IPostService ips = new PostServiceImp();
	IUserService ius = new UserServiceImp();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			req.setCharacterEncoding("utf-8");
			List<Message>list = new ArrayList<Message>();
			list = ips.showAll();
			PrintWriter out =resp.getWriter();
			Gson gson = new Gson();
			String rtnStr = gson.toJson(list); 
			
			out.write(rtnStr);
	}
}
