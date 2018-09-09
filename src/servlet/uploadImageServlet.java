package servlet;


import com.google.gson.Gson;

import bean.User;

import org.apache.commons.fileupload.disk.DiskFileItem;
import service.IUserService;
import service.imp.UserServiceImp;


import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/img-upload")
public class uploadImageServlet extends HttpServlet {
    IUserService iUserService = new UserServiceImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        System.err.println("layui upload ");
        Map<String, String> resData = new HashMap<String, String>();
        resData.put("data", "layui upload image success");
        Gson gson = new Gson();
        String str = gson.toJson(resData);
        out.println(str);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
        String imgUrl = req.getParameter("imgUrl");
//        User user=(User) req.getSession().getAttribute("user");
//        String uName = user.getuName();//获取之前的用户名
//        User userNew = new User(uName,user.getuPass(),imgUrl);
//        req.getSession().setAttribute("user",userNew);
        System.out.println("read imgUrl: " + imgUrl);
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
//        String uName = req.getSession().getAttribute("uName").toString();//获取用户名
        String uName = "shiguoqian";
        if (iUserService.updateImgById(uName, imgUrl)) {//设置头像成功
            out.println("upload successfully");
        } else {
            out.println("upload error");
        }
    }
}
