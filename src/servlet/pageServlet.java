package servlet;

import bean.User;
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

public class pageServlet extends HttpServlet {
    IPageService iPageService = new PageServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("进入...");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        String currentPage = req.getParameter("currentPage");
        //System.out.println(currentPage);
        Page page = iPageService.setPage(currentPage);
        List<Object> userList = iPageService.getUserByPage(page);

        userList.add(page);
        Gson gson = new Gson();
        String objectStr = gson.toJson(userList);
        //System.out.println(objectStr);
        out.print(objectStr);
    }
}
