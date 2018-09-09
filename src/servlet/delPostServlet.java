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
 * 后台管理员删除帖子
 *
 * 史国茜
 */
public class delPostServlet extends HttpServlet {
    IPostService iPostService = new PostServiceImp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean delFlag = true;
        PrintWriter out = resp.getWriter();
        if (req.getParameter("flag").equals("0"))//单个删除帖子
        {
            int pId = Integer.parseInt(req.getParameter("pId"));
            delFlag = iPostService.DelPostById(pId);//删帖成功
        }else if (req.getParameter("flag").equals("1")){//多个删除帖子
            String[] pIdArr = req.getParameterValues("pId");
            for (int i=0;i<pIdArr.length;i++){
                delFlag = iPostService.DelPostById(Integer.parseInt(pIdArr[i]));
                if (delFlag==false)
                    return;//只要有一个删除失败,就退出循环
            }
        }else if (req.getParameter("flag").equals("2")){//单个删除收藏贴
            int pId = Integer.parseInt(req.getParameter("pId"));
            delFlag = iPostService.delCollectById(pId);//删帖成功
        }
        if (delFlag){
            out.print("true");
        }else{
            out.print("false");
        }
        out.close();
    }
}
