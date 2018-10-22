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
 * @Date: 2018/10/20 14:10
 * 明确需求,整理思路,步步实现,规范编写,测试功能,总结经验.
 * 用户注册  已过时 抽取到UserServlet 中
 */
//@WebServlet("/registerUserServlet")
public class RegisterUserServlet extends HttpServlet {

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
////      tomcat 显示台中文乱码
//        request.setCharacterEncoding("utf-8");
////        获取用户输入的验证码
//        String check = request.getParameter("check");
////        从session域中取出
//        HttpSession session = request.getSession();
//        String checkCode = (String) session.getAttribute("checkCode");
//        session.removeAttribute("checkCode");
//        //        比较 用户输入验证码和 生成验证码
//        if (new UserServlet().compareCheckCode(response, check, checkCode)) {
//            return;
//        }
////            验证码通过
////            获取 Map数据
//            Map<String, String[]> map = request.getParameterMap();
////            封装map
//            User user = new User();
//            try {
//                BeanUtils.populate(user,map);
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            }
////            调用ServiceImpl 的 registerUser方法
//            UserService service = new UserServiceImpl();
//            boolean flag = service.registUser(user);
//            ResultInfo info = new ResultInfo();
////            响应结果 true 注册成功
//            if (flag){
//                info.setFlag(true);
//            }else {
////                注册失败 用户名被占用
//                info.setFlag(false);
//                info.setErrorMsg("注册失败,用户名被占用");
//            }
////            将info对象序列化json对象
//            ObjectMapper mapper = new ObjectMapper();
//            String json = mapper.writeValueAsString(info);
//            //将json数据写回客户端
//            //设置content-type
//            response.setContentType("application/json;charset=utf-8");
//            response.getWriter().write(json);
//    }
//
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        this.doPost(request, response);
//    }
}
