package servlet;

import bean.User;
import service.IUserService;
import service.imp.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class addFriendServlet extends HttpServlet {
    IUserService iUserService = new UserServiceImp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servlet");
        int friendId = Integer.parseInt(req.getParameter("friendId"));//获取他人id
        String flag = req.getParameter("flag");//判断是查询还是添加
        PrintWriter out = resp.getWriter();
//        int selfId = ((User)req.getSession().getAttribute("user")).getuId();
        int selfId = 1;
        if (friendId==selfId){//自己不能添加自己,也不能关注自己
            System.out.println("不能关注自己");
            out.print("false");
        }
        if (flag.equals("query")){//查询
            if (!iUserService.queryAtteById(selfId,friendId)){
                out.print("true");//可以关注
            }else{
                System.out.println("不可以关注");
                out.print("false");//在关注列表中,不可以关注
            }
        }else if (flag.equals("add")){//添加
            if (iUserService.addFriendById(selfId,friendId)){//添加成功
                out.print("true");
            }else{
                out.print("false");//添加失败
            }
        }
    }
}
