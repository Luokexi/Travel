package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Category;

import java.util.List;

/**
 * @Author: Luokexi
 * @Date: 2018/10/22 21:18
 * 明确需求,整理思路,步步实现,规范编写,测试功能,总结经验.
 */
public interface CategoryDao {

    /**
     * 查询所有路线
     * @return
     */
    List<Category>findAll();
}
