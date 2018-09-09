package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import bean.Message;
import bean.Post;
import bean.User;
import service.imp.PostServiceImp;
import service.imp.UserServiceImp;

public class PostServlet extends HttpServlet {
	UserServiceImp userService = new UserServiceImp();
	PostServiceImp postService = new PostServiceImp();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String flag = req.getParameter("flag");
		if ("shouyeTop".equals(flag)) {
			
			ArrayList<Message> list = postService.getAllTopPost();
			PrintWriter pw = resp.getWriter();
			Gson gson = new Gson();
			String rtnStr = gson.toJson(list);
			
			pw.write(rtnStr);
		} else if ("sendpost".equals(flag)) {
			Post post = null;
			User user = (User) req.getSession().getAttribute("user");
			
			String uName = user.getuName();
			
			String type = req.getParameter("class");
			String title = req.getParameter("title");
			String project = req.getParameter("project");
			String version = req.getParameter("version");
			String browser = req.getParameter("browser");
			String content = req.getParameter("content");
			String experience = req.getParameter("experience");
			if ("0".equals(type)) {
				post = new Post(uName, type, title, project, version, browser, content, experience);
				userService.sendPost(post);
				resp.sendRedirect("front/html/jie/shouye.jsp");
			} else if ("100".equals(type) || "99".equals(type) || "101".equals(type) || "168".equals(type)
					|| "169".equals(type)) {
				post = new Post(uName, type, title, content, experience);
				userService.sendPost(post);
				resp.sendRedirect("front/html/jie/shouye.jsp");
			}
		}
		// wanp点击帖子呈现内容以及评论
		else if ("getPostById".equals(flag)) {
			System.out.println("进入帖子内容servlet");
			String PID = req.getParameter("PID");
			
			int pID = Integer.parseInt(PID);
			System.out.println(pID);
			Message message=postService.getMessageById(pID);
			PrintWriter pw = resp.getWriter();
			Gson gson = new Gson();
			String string = gson.toJson(message);
			System.out.println(message);
			pw.write(string);

		}
	}
}
