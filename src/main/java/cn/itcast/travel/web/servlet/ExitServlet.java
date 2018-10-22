package cn.itcast.travel.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author: Luokexi
 * @Date: 2018/10/22 10:31
 * 明确需求,整理思路,步步实现,规范编写,测试功能,总结经验.
 * 用户退出
 */
@WebServlet("/exitServlet")
public class ExitServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        后台销毁session中的数据
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
//        response  login.html
        response.sendRedirect(request.getContextPath()+"/login.html");


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
