package cn.itcast.travel.domain;

import java.util.List;

/**
 * @Author: Luokexi
 * @Date: 2018/10/23 14:01
 * 明确需求,整理思路,步步实现,规范编写,测试功能,总结经验.
 * 分页对象
 */
public class PageBean<T> {

    /**
     * totalCount   总纪录数
     * totalPage    总页数
     * currentPage  当前页码
     * pageSize     每页显示的条目
     * list         每页展示的数据
     */
    private int totalCount;
    private int totalPage;
    private int currentPage;
    private int pageSize;
    private List<T> list;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", list=" + list +
                '}';
    }
}
