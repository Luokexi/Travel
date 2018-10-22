package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.CategoryDao;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @Author: Luokexi
 * @Date: 2018/10/22 21:19
 * 明确需求,整理思路,步步实现,规范编写,测试功能,总结经验.
 */
public class CategoryDaoImpl implements CategoryDao {

        private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    /**
     * 查询所有路线
     * @return
     */
    @Override
    public List<Category> findAll() {
        return null;
    }
}
