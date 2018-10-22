package cn.itcast.travel.web.servlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: Luokexi
 * @Date: 2018/10/22 14:32
 * 明确需求,整理思路,步步实现,规范编写,测试功能,总结经验.
 * 作为提供方法的Servlet
 */

public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(this);
//        获取URI 根据URI 截取方法 执行方法
        String requestURI = req.getRequestURI();
//        substring() 截取字符串包括开始的索引不包括结束的索引  lastIndexOf('/') 最后一次 / 出现的索引
        String method = requestURI.substring(requestURI.lastIndexOf('/')+1);

        System.out.println("方法名: "+method);
//        调用当前对象的字节码对象执行方法
        try {
            Method declaredMethod = this.getClass().getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
//            暴力反射
//            declaredMethod.setAccessible(true);
//            执行方法
            declaredMethod.invoke(this, req, resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 直接将传入的对象序列化为json 写回客户端
     * @param obj
     */
    public void writeValue(Object obj,HttpServletResponse response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),obj);
    }

    /**
     * 将传入的对象序列化为json
     * @param obj
     * @return
     */
    public String writeValueAsString(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }
}
