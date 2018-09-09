package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.VerifyCodeUtils;
/**
 * 验证码原理:
 * ：在servlet中随机生成一个指定位置的验证码,一般为四位,然后把该验证码保存到session中.在通过Java的绘图类以图片的形式输出该验证码。
 * 为了增加验证码的安全级别,可以输出图片的同时输出干扰线,
 * 最后在用户提交数据的时候,在服务器端将用户提交的验证码和Session保存的验证码进行比较。
 * @author 郝伟    
 *
 */
//CreateCodeServlet目的是为了创建验证码图片流
public class CreateCodeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   //取消浏览器缓存
		resp.setHeader("Pragma", "No-cache");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setDateHeader("Expires", 0);
		resp.setContentType("image/jpeg");        //设置上下文类型，图片响应
		//获取生成的验证码，验证码长度为4
	    String code=VerifyCodeUtils.generateVerifyCode(4);
	   //把生成的验证码存放到session中
	    req.getSession().setAttribute("checkCode", code);
	    //通过java的绘图类，以图片的形式输出验证码
	    VerifyCodeUtils.outputImage(100, 32, resp.getOutputStream(), code);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("进入doPost()方法");
	}
}
