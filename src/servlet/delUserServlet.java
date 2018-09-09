package servlet;

import service.IUserService;
import service.imp.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class delUserServlet extends HttpServlet {
    IUserService iUserService = new UserServiceImp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean delFlag = true;
        PrintWriter out = resp.getWriter();
        if (req.getParameter("flag").equals("0"))//单个删除
        {
            int uId = Integer.parseInt(req.getParameter("uId"));
            delFlag = iUserService.delUserById(uId);//删帖成功
        }else{//多个删除
            String[] uIdArr = req.getParameterValues("uId");
            for (int i=0;i<uIdArr.length;i++){
                delFlag = iUserService.delUserById(Integer.parseInt(uIdArr[i]));
                if (delFlag==false)
                    return;//只要有一个删除失败,就退出循环
            }
        }
        if (delFlag){
            out.print("true");
        }else{
            out.print("false");
        }
        out.close();
    }
}
