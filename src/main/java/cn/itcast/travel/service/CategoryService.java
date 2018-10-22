package cn.itcast.travel.service;

import cn.itcast.travel.domain.Category;

import java.util.List;

/**
 * @Author: Luokexi
 * @Date: 2018/10/22 21:21
 * 明确需求,整理思路,步步实现,规范编写,测试功能,总结经验.
 */
public interface CategoryService {

    /**
     *
     * @return
     */
    List<Category> findAll();
}
