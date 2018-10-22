package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.CategoryDao;
import cn.itcast.travel.dao.impl.CategoryDaoImpl;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.CategoryService;

import java.util.List;

/**
 * @Author: Luokexi
 * @Date: 2018/10/22 21:23
 * 明确需求,整理思路,步步实现,规范编写,测试功能,总结经验.
 */
public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao = new CategoryDaoImpl();

    /**
     * 查询所有路线
     * @return
     */
    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }
}
