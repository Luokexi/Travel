package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Route;

import java.util.List;

/**
 * @Author: Luokexi
 * @Date: 2018/10/23 14:10
 * 明确需求,整理思路,步步实现,规范编写,测试功能,总结经验.
 */
public interface RouteDao {

    /**
     * 根据类别 cid 查询总记录数
     * @param cid
     * @return
     */
    int findTotalCount(int cid);
    /**
     * 分页查询
     * @param cid
     * @param start
     * @param pageSize
     * @return
     */
    public List<Route> findByPage(int cid, int start, int pageSize);
}
