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

import bean.Post;
import bean.User;
import service.IPageService;
import service.IPostService;
import service.imp.PageServiceImpl;
import service.imp.PostServiceImp;
import util.Page;

public class CollectServlet extends HttpServlet{
	IPageService iPageService = new PageServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		IPostService ips = new PostServiceImp();
//		System.out.println("进入查看用户收藏帖servlet");
//		req.setCharacterEncoding("utf-8");
////		User user = (User)req.getSession().getAttribute("user");
////		int uId = user.getuId();
//		int uId = 1;
//		List<Post> list = new ArrayList();
//		list = ips.getAllCollectById(uId);
//		PrintWriter out =resp.getWriter();
//		Gson gson = new Gson();
//		String rtnStr = gson.toJson(list);
//		System.out.println("rtnstr:"+rtnStr);
//		//System.out.println(rtnStr);
//		out.write(rtnStr);


		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json;charset=utf-8");
		PrintWriter out = resp.getWriter();
		//获取当前页面---分页
		String currentPageStr = req.getParameter("currentPage");
//       如果没有session,会报空指针异常
//        int uId = ((User) req.getSession().getAttribute("user")).getuId();
		int uId = 1;
		Page page = iPageService.setPage(currentPageStr,uId,"collect");
		List<Object> postList = iPageService.getCollectByPage(page,uId);
		postList.add(page);
		Gson gson = new Gson();
		String objectStr = gson.toJson(postList);
		out.print(objectStr);
		out.close();
	}
}
