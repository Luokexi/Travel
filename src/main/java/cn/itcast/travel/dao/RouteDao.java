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
     * 根据类别 cid 用户输入的路线名  查询总记录数
     * @param cid
     * @param rname
     * @return
     */
    int findTotalCount(int cid, String rname);


    /**
     * 分页查询
     * @param cid
     * @param start
     * @param pageSize
     * @param rname
     * @return
     */
    public List<Route> findByPage(int cid, int start, int pageSize, String rname);

    /**
     * 根据rid查询
     * @param rid
     * @return
     */
    public Route findOne(int rid);
}
