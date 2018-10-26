package cn.itcast.travel.dao;


import cn.itcast.travel.domain.RouteImg;

import java.util.List;

/**
 * @Author: Luokexi
 * @Date: 2018/10/23 14:10
 * 明确需求,整理思路,步步实现,规范编写,测试功能,总结经验.
 */
public interface RouteImgDao {


    /**
     *  根据Rid查询图片集合
     * @param rid
     * @return
     */
    public List<RouteImg> findByRid(int rid);

}
