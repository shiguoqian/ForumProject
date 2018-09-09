package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import bean.User;
import service.IPostService;
import service.imp.PostServiceImp;

public class GetPostsByTypeServlet extends HttpServlet {
	IPostService ipService =new PostServiceImp();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//System.out.println("进入了Type方法");
		req.setCharacterEncoding("utf-8");
		String type=req.getParameter("type");
		//System.out.println(type);
		ArrayList list = new ArrayList();
		PrintWriter out =resp.getWriter();
		Gson gson = new Gson();
		String result = gson.toJson(ipService.getPostsByType(type));
		//System.out.println(result);
		out.write(result);
	}

}
