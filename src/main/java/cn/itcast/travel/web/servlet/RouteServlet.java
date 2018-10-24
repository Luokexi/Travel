package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.service.RouteService;
import cn.itcast.travel.service.impl.RouteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Luokexi
 * @Date: 2018/10/23 14:08
 * 明确需求,整理思路,步步实现,规范编写,测试功能,总结经验.
 */
@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {

    private RouteService routeService = new RouteServiceImpl();
    /**
     * 分页查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        得到前台输入给后台的数据  当前页码 currentPage  每页展示的条目 pageSize  类别 cid
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        String cidStr = request.getParameter("cid");
//        接收搜索框里 用户输入的线路名称  解决get请求 中文乱码问题
        String rnameStr = request.getParameter("rname");
        if ("null".equals(rnameStr)){
            rnameStr = "";
        }
//        rname 不传递值 默认是 ?? 的情况
//        对得到的数据进行处理  非空 长度不为0的判断
//        当前页码是int类型的 获取数据的类型是String
        int currentPage = 1;
//        如果当前页码不为空 或者长度大于0
        if (currentPageStr!= null && currentPageStr.length()>0){
//            类型转换
            currentPage = Integer.parseInt(currentPageStr);
        }else {
//            设置 currentPage默认值 1
            currentPage = 1;
        }
//        处理类别cid 参数
        int cid = 5;
        if(cidStr != null && cidStr.length() > 0 && !"null".equals(cidStr)){
            cid = Integer.parseInt(cidStr);
        }

//        处理当前页码
        int pageSize = 1;
//        每页显示条数，如果不传递，默认每页显示5条记录
        if(pageSizeStr != null && pageSizeStr.length() > 0){
            pageSize = Integer.parseInt(pageSizeStr);
        }else{
            pageSize = 5;
        }

//        调用RouteServiceImpl 查询 返回PageBean对象
        PageBean<Route> routePageBean = routeService.pageQuery(cid, currentPage, pageSize,rnameStr);
//        将PageBean序列化JSON对象 返回给前台
        writeValue(routePageBean,response);
    }


    /**
     * 根据 rid 查询路线图
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findByRid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

//        获取 rid
        String rid = request.getParameter("rid");
//        调用 RouteServiceImpl 查询

    }
}
