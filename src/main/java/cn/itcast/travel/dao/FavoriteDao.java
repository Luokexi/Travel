package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Favorite;

/**
 * @Author: Luokexi
 * @Date: 2018/10/25 19:17
 * 明确需求,整理思路,步步实现,规范编写,测试功能,总结经验.
 */
public interface FavoriteDao {

    Favorite findByRidAndUid(int rid, int uid);
}
