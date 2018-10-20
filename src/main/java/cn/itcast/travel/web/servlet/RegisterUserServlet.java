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
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author : Luokexi
 * @date : 2018/10/19 21:10
 * 明确需求,整理思路,步步实现,规范编写,测试功能,总结经验.
 */
@WebServlet("/registerUserServlet")
public class RegisterUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {

//        先判断验证码是否正确
        String check = request.getParameter("check");
        HttpSession session = request.getSession();
        String checkCodeServer = (String) session.getAttribute("checkCodeServer");
        //为了保证验证码只能使用一次
        session.removeAttribute("checkCodeServer");

        //比较
        if(checkCodeServer == null || !checkCodeServer.equalsIgnoreCase(check)){
            //验证码错误
            ResultInfo info = new ResultInfo();
            //注册失败
            info.setFlag(false);
            info.setErrorMsg("验证码错误");
            //将info对象序列化为json
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(info);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
            return ;
        }


//        获取Map<String,String[]>
        Map<String, String[]> map = request.getParameterMap();
//        封装User
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        调用UserServiceImpl
        UserService service = new UserServiceImpl();
        boolean flag = service.registUser(user);
        ResultInfo info = new ResultInfo();
//        根据响应结果来判断 flag = true 成功
        if (flag){
//            注册成功
            info.setFlag(true);
        }else {
//            注册失败
            info.setFlag(false);
//            失败信息
            info.setErrorMsg("注册失败");
        }
//        将info对象序列化为JSON对象
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(info);
//        将json数据写回客户端  因为是字符串的数据
//        设置响应头的 content-type
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        this.doPost(request, response);
    }
}
