package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author: Luokexi
 * @Date: 2018/10/22 8:40
 * 明确需求,整理思路,步步实现,规范编写,测试功能,总结经验.
 * 用户登录成功之后的用户名回显
 */
@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        从session域中获取用户的信息
        HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute("user");
        if (user!=null){
        System.out.println("user姓名: "+user.getUsername());
//        Object user =  request.getSession().getAttribute("user");
//        System.out.println("从Session域中获取的user的名字: "+user.getName());
//         Jackson 将Java数据转成JSON对象
        ObjectMapper mapper = new ObjectMapper();
//        设置响应的格式
        response.setContentType("application/json;charset=utf-8");
//       直接写回给客户端
        mapper.writeValue(response.getOutputStream(),user);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
