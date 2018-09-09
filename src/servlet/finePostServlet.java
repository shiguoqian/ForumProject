package servlet;

import service.IPostService;
import service.imp.PostServiceImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class finePostServlet extends HttpServlet {
    IPostService iPostService = new PostServiceImp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pId = Integer.parseInt(req.getParameter("pId"));
        int fineFlag = Integer.parseInt(req.getParameter("fineFlag"));
        //System.out.println("pId:"+pId+"fineFlag:"+fineFlag);
        PrintWriter out = resp.getWriter();
        if (iPostService.finePost(pId,fineFlag)){
            out.print("true");
        }else{
            out.print("flase");
        }
        out.close();
    }
}
