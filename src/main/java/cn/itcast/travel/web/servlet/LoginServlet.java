package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Author: Luokexi
 * @Date: 2018/10/21 0:34
 * 明确需求,整理思路,步步实现,规范编写,测试功能,总结经验.
 * 用户登录 已过时现已经抽取到UserServlet中
 */
//@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
////        验证码校验  获取用户的输入
//        String check = request.getParameter("check");
////        从 Session域中获取 生成的验证码
//        HttpSession session = request.getSession();
//        String checkCode = (String) session.getAttribute("checkCode");
////        比较验证码
//        if (checkCode ==null || !checkCode.equalsIgnoreCase(check)){
////            验证码错误 或者生成验证码为空
//            ResultInfo info = new ResultInfo();
//            info.setFlag(false);
//            info.setErrorMsg("验证码错误");
////            序列化对象响应给前台
//            ObjectMapper mapper = new ObjectMapper();
//            String json = mapper.writeValueAsString(info);
//            response.setContentType("application/json;charset=utf-8");
//            response.getWriter().write(json);
//            return ;
//        }
////        获取用户名和密码
//        Map<String, String[]> map = request.getParameterMap();
////        封装Map
//        User user = new User();
//        try {
//            BeanUtils.populate(user,map);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
////        调用 UserServiceImpl 查询
//        UserService service = new UserServiceImpl();
////        返回查询的用户 loginUser
//        User loginUser = service.login(user);
////        封装对象返回 信息
//        ResultInfo info = new ResultInfo();
////        loginUser 注册方法返回的 对象
//        if (loginUser == null){
////          loginUser为null 用户名密码错误 因为就返回这些内容
//            info.setFlag(false);
//            info.setErrorMsg("用户名或密码错误");
//        }
////        如果用户名密码正确 再判断用户的激活状态
//        if (!"Y".equals(loginUser.getStatus()) && loginUser!=null){
////            用户未激活
//            info.setFlag(false);
//            info.setErrorMsg("您尚未激活,请您激活");
//        }
////        登录成功的判断 loginUser!=null loginUser.getStatus = "Y"
//        if ("Y".equals(loginUser.getStatus()) && loginUser!=null){
////            成功
//            info.setFlag(true);
////        存到session中回显 用户信息
//            HttpSession httpSession = request.getSession();
//            httpSession.setAttribute("user",loginUser);
//        }
////        响应数据
//        ObjectMapper mapper = new ObjectMapper();
//        response.setContentType("application/json;charset=utf-8");
//        mapper.writeValue(response.getOutputStream(),info);
//
//    }

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        this.doPost(request, response);
//    }
}
