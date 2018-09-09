package servlet;

import service.IPostService;
import service.imp.PostServiceImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 通过审核
 *
 * 史国茜
 */
public class passPostServlet extends HttpServlet {
    IPostService iPostService = new PostServiceImp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("servlet");
        int pId = Integer.parseInt(req.getParameter("pId"));
        PrintWriter out = resp.getWriter();
        if (iPostService.passPost(pId)){
            //System.out.println("true");
            out.print("true");
        }else{
            //System.out.println("false");
            out.print(false);
        }
    }
}
