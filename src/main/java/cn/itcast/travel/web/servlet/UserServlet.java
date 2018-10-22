package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Author: Luokexi
 * @Date: 2018/10/22 15:18
 * 明确需求,整理思路,步步实现,规范编写,测试功能,总结经验.
 */

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {

    // 声明成员变量 多处调用
    private UserService service = new UserServiceImpl();
//
    private BaseServlet base = new BaseServlet();

    /**
     * 用户注册
     * @param request 请求
     * @param response 响应
     * @throws ServletException
     * @throws IOException
     */
    public void registUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        获取用户输入的验证码
        String check = request.getParameter("check");
//        从session域中取出
        HttpSession session = request.getSession();
        String checkCode = (String) session.getAttribute("checkCode");
        session.removeAttribute("checkCode");
        //        比较 用户输入验证码和 生成验证码
        if (compareCheckCode(response, check, checkCode)) {
            return;
        }
//            验证码通过
//            获取 Map数据
        Map<String, String[]> map = request.getParameterMap();
//            封装map
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        boolean flag = service.registUser(user);
        ResultInfo info = new ResultInfo();
//            响应结果 true 注册成功
        if (flag){
            info.setFlag(true);
        }else {
//                注册失败 用户名被占用
            info.setFlag(false);
            info.setErrorMsg("注册失败,用户名被占用");
        }
//        将对象序列化为json字符串
        base.writeValueAsString(info);
    }


    /**
     * 比较用户输入验证码和生成验证码
     * @param response
     * @param check
     * @param checkCode
     * @return
     * @throws IOException
     */
    public boolean compareCheckCode(HttpServletResponse response, String check, String checkCode) throws IOException {
        if (checkCode == null || !checkCode.equalsIgnoreCase(check)){
            ResultInfo info = new ResultInfo();
            info.setFlag(false);
            info.setErrorMsg("验证码错误");
//            将info 序列化为 JSON对象 响应给前台
            base.writeValueAsString(info);
            return true;
        }
        return false;
    }

    /**
     * 用户名回显
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        从session域中获取用户的信息
        HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute("user");
        if (user!=null){
            base.writeValue(user,response);
        }
    }

    /**
     * 用户登陆
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void loginUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        验证码校验  获取用户的输入
        String check = request.getParameter("check");
//        从 Session域中获取 生成的验证码
        HttpSession session = request.getSession();
        String checkCode = (String) session.getAttribute("checkCode");
//        比较验证码
        if (checkCode ==null || !checkCode.equalsIgnoreCase(check)){
//            验证码错误 或者生成验证码为空
            ResultInfo info = new ResultInfo();
            info.setFlag(false);
            info.setErrorMsg("验证码错误");
//            序列化对象响应给前台
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(info);
            System.out.println("注册json字符串: "+json);
            base.writeValueAsString(info);
            return ;
        }
//        获取用户名和密码
        Map<String, String[]> map = request.getParameterMap();
//        封装Map
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

//        调用 UserServiceImpl 查询
         service = new UserServiceImpl();
//        返回查询的用户 loginUser
        User loginUser = service.login(user);
        System.out.println("用户姓名: "+loginUser.getUsername());
//        封装对象返回 信息
        ResultInfo info = new ResultInfo();
//        loginUser 注册方法返回的 对象  为什么 loginUser
        if (loginUser == null){
//          loginUser为null 用户名密码错误 因为就返回这些内容
            info.setFlag(false);
            info.setErrorMsg("用户名或密码错误");
        }
//        如果用户名密码正确 再判断用户的激活状态
        if (!"Y".equals(loginUser.getStatus()) && loginUser!=null){
//            用户未激活
            info.setFlag(false);
            info.setErrorMsg("您尚未激活,请您激活");
        }
//        登录成功的判断 loginUser!=null loginUser.getStatus = "Y"
        if ("Y".equals(loginUser.getStatus()) && loginUser!=null){
//            成功
            info.setFlag(true);
//        存到session中回显 用户信息
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("user",loginUser);
        }
//        响应数据
        base.writeValue(info,response);
    }

    /**
     * 用户退出
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void exitUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        后台销毁session中的数据
       request.getSession().invalidate();
//        response  login.html
        response.sendRedirect(request.getContextPath()+"/login.html");
    }

    /**
     * 用户激活
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void activeUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        获取激活码
        String code = request.getParameter("code");
//        根据code 查找用户 先判断 code是否为null
        if (code!=null){
//      调用UserServiceImpl 查询
            service = new UserServiceImpl();
            boolean flag = service.active(code);
//        定义一个 字符串回显页面
            String msg = null;
            if (flag){
//            true 激活成功
                msg = "激活成功, 请<a href='/travel/login.html'>登录</a>";
            }else {
                msg = "激活失败,请联系管理员,或者重新注册.";
            }
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(msg);
        }
    }
}
