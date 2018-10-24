package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.dao.impl.RouteDaoImpl;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.service.RouteService;

import java.util.List;

/**
 * @Author: Luokexi
 * @Date: 2018/10/23 14:13
 * 明确需求,整理思路,步步实现,规范编写,测试功能,总结经验.
 */
public class RouteServiceImpl implements RouteService {

    private RouteDao routeDao = new RouteDaoImpl();

    /**
     *  根据类别cid 分页查询数据
     * @param cid
     * @param currentPage
     * @param pageSize
     * @param rname
     * @return 封装 PageBean对象
     */
    @Override
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize, String rname) {

        PageBean<Route> pageBean  = new PageBean<>();
//        设置当前页码
        pageBean.setCurrentPage(currentPage);
//        每页显示的条目
        pageBean.setPageSize(pageSize);
//        总记录数 totalCount
        int totalCount = routeDao.findTotalCount(cid,rname);
//        设置总记录数
        pageBean.setTotalCount(totalCount);
//        总页数 = 总记录数 % 每页显示的条目 ==0  ? :
        int totalPage = totalCount % pageSize == 0 ? totalCount/pageSize : (totalCount/pageSize) + 1;
//        设置总页数
        pageBean.setTotalPage(totalPage);
//        设置开始的索引   =  (当前页码 -1 ) * 每页显示的条目
        int start = (currentPage - 1) * pageSize;
//        每页展示的数据
        List<Route> routeList = routeDao.findByPage(cid, start, pageSize,rname);
//        设置每页展示的数据
        pageBean.setList(routeList);
        return pageBean;
    }
}
