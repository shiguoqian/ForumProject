package servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.google.gson.Gson;
import service.IPageService;
import service.imp.PageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文章列表servlet
 *
 * 史国茜
 */
public class newServlet extends HttpServlet {
    IPageService iPageService = new PageServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("进入servlet");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=utf-8");

        //获取page和limit
        String currentPage = req.getParameter("page");
        String limit = req.getParameter("limit");

        //变量声明
        PrintWriter out = resp.getWriter();
        Gson gson = new Gson();
        JSONArray jsonArray = new JSONArray();

        List<Object> postList =iPageService.getPostByPage(iPageService.setPage(currentPage,limit));
        int total = iPageService.getPostTotalCount();

        //json.tojson()属于fastjson包,自动忽略null值,所以project被忽略,传值没有穿project
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",total);
        map.put("data",postList);
        String jsonStr = gson.toJson(map);
        Object json = JSON.toJSON(jsonStr);
        out.print(json);
    }
}
