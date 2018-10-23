package cn.itcast.travel.service;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;

/**
 * @Author: Luokexi
 * @Date: 2018/10/23 14:12
 * 明确需求,整理思路,步步实现,规范编写,测试功能,总结经验.
 */
public interface RouteService {

    /**
     * 根据类别cid 分页查询数据
     * @param cid
     * @param currentPage
     * @param pageSize
     * @return
     */
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize);


}
