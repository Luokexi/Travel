package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.CategoryDao;
import cn.itcast.travel.dao.impl.CategoryDaoImpl;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.CategoryService;
import cn.itcast.travel.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
//        先去redis中查询数据 找不到就去数据库中查找
//        获取Jedis的客户端 首先打开redis server
        Jedis jedis = JedisUtil.getJedis();
//        用sorted set 查询 key 范围
//        Set<String> categories = jedis.zrange("category", 0, -1);
        Set<Tuple> tupleSet = jedis.zrangeWithScores("category", 0, -1);
//        将查询的数据转换成List
        List<Category> categoryList = null;
//        如果为空 去数据库中查询 再存入到redis中
        if (tupleSet.size()==0 || tupleSet == null){
//            到数据库中查询
            System.out.println(" 到数据库中查询...");
            categoryList = categoryDao.findAll();
//            将List中的数据存到 redis中 
//            遍历list 
            for (int i = 0; i < categoryList.size(); i++) {
//                一个一个添加
                jedis.zadd("category",categoryList.get(i).getCid(),categoryList.get(i).getCname());
            }
        }else {
//        redis中数据不为空返回的是 Set 集合 需要的是List集合
            System.out.println(" 到redis 中查询...");
            categoryList = new ArrayList<>();
//           遍历Set 将数据存到 categoryList中返回
            for (Tuple tuple : tupleSet) {
                Category category = new Category();
                category.setCname(tuple.getElement());
//                score 是double类型的
                category.setCid((int)tuple.getScore());
                categoryList.add(category);
            }
        }
        return categoryList;
    }
}
