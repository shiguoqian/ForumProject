package servlet;

import com.google.gson.Gson;
import service.IPageService;
import service.imp.PageServiceImpl;
import util.Page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 显示某用户帖子
 *
 * 史国茜
 */
public class userPostsServlet extends HttpServlet {
    IPageService iPageService = new PageServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        //获取当前页面---分页
        String currentPageStr = req.getParameter("currentPage");
//       如果没有session,会报空指针异常
//        int uId = ((User) req.getSession().getAttribute("user")).getuId();
        int uId = 1;
        Page page = iPageService.setPage(currentPageStr,uId);
        List<Object> postList = iPageService.getPostByPage(page,uId);
        postList.add(page);
        Gson gson = new Gson();
        String objectStr = gson.toJson(postList);
       
        out.print(objectStr);
        out.close();
    }
}
