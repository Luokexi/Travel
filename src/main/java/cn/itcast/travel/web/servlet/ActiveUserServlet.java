package cn.itcast.travel.web.servlet;

import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Luokexi
 * @Date: 2018/10/20 1:28
 * 明确需求,整理思路,步步实现,规范编写,测试功能,总结经验.
 * 用户激活 已过时 抽取到UserServlet中
 */
//@WebServlet("/activeUserServlet")
public class ActiveUserServlet extends HttpServlet {
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
////        获取激活码
//        String code = request.getParameter("code");
////        根据code 查找用户 先判断 code是否为null
//        if (code!=null){
////      调用UserServiceImpl 查询
//        UserService service = new UserServiceImpl();
//        boolean flag = service.active(code);
////        定义一个 字符串回显页面
//            String msg = null;
//        if (flag){
////            true 激活成功
//            msg = "激活成功, 请<a href = 'login.html'>登录</a>";
//        }else {
//            msg = "激活失败,请联系管理员,或者重新注册.";
//        }
//        response.setContentType("text/html;charset=utf-8");
//        response.getWriter().write(msg);
//        }
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        this.doPost(request, response);
//    }
}
