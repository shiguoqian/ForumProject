package service.imp;

import dao.IPageDao;
import dao.imp.PageDaoImpl;
import service.IPageService;
import util.Page;

import java.util.List;

/**
 * 分页service实现类
 *
 * 史国茜
 */
public class PageServiceImpl implements IPageService {
    IPageDao iPageDao = new PageDaoImpl();

    @Override
    public List<Object> getUserByPage(Page page) {
        return iPageDao.getUserByPage(page);
    }

    @Override
    public List<Object> getPostByPage(Page page) {
        return iPageDao.getPostByPage(page);
    }

    @Override
    public List<Object> getPostByPage(Page page, int uId) {
        return iPageDao.getPostByPage(page, uId);
    }

    @Override
    public List<Object> getCollectByPage(Page page, int uId) {
        return iPageDao.getCollectByPage(page, uId);
    }

    @Override
    public int getUserTotalCount() {
        return iPageDao.getUserTotalCount();
    }

    @Override
    public int getPostTotalCount() {
        return iPageDao.getPostTotalCount();
    }

    @Override
    public int getPostTotalCount(int uId) {
        return iPageDao.getPostTotalCount(uId);
    }

    @Override
    public int getCollectTotalCount(int uId) {
        return iPageDao.getCollectTotalCount(uId);
    }

    @Override
    public Page setPage(String currentPageStr) {
        return setPage(currentPageStr, 0);
    }

    @Override
    public Page setPage(String currentPageStr, String limitStr) {
        int currentPage = Integer.parseInt(currentPageStr);
        int limit = Integer.parseInt(limitStr);
        Page page = new Page(limit, currentPage);
        int totalCount = iPageDao.getPostTotalCount();
        page.setTotalCount(totalCount);
        int totalPage = page.getTotalPage();//获取的同时也设置了
        //对首页末页进行控制
        if (currentPage < 1) {
            currentPage = 1;//当前页不能小于首页
        } else if (currentPage > totalPage) {
            currentPage = totalPage;//当前页不能大于末页
        }
        //设置当前页码
        page.setCurrentPage(currentPage);
        return page;
    }

    @Override
    public Page setPage(String currentPageStr, int uId) {
        int pageSize = 10;//固定每页显示10条
        int totalCount = -1;
        if (currentPageStr == null || "".equals(currentPageStr)) {
            currentPageStr = "1";//如果页码为null,说明是第一次登录,将设置当前页码为1
        }
        int currentPage = Integer.parseInt(currentPageStr);
        Page page = new Page(pageSize, currentPage);

        if (uId == 0) {
            totalCount = iPageDao.getPostTotalCount();
        } else {
            totalCount = iPageDao.getPostTotalCount(uId);
        }
        System.out.println(totalCount);
        page.setTotalCount(totalCount);
        int totalPage = page.getTotalPage();//获取的同时也设置了
        //对首页末页进行控制
        if (currentPage < 1) {
            currentPage = 1;//当前页不能小于首页
        } else if (currentPage > totalPage) {
            currentPage = totalPage;//当前页不能大于末页
        }
        //设置当前页码
        page.setCurrentPage(currentPage);
        return page;
    }

    @Override
    public Page setPage(String currentPageStr, int uId, String flag) {
        Page page = null;
        if (flag.equals("collect")) {
            int pageSize = 10;//固定每页显示10条
            int totalCount = -1;
            if (currentPageStr == null || "".equals(currentPageStr)) {
                currentPageStr = "1";//如果页码为null,说明是第一次登录,将设置当前页码为1
            }
            int currentPage = Integer.parseInt(currentPageStr);
            page = new Page(pageSize, currentPage);

            totalCount = iPageDao.getCollectTotalCount(uId);
            System.out.println(totalCount);
            page.setTotalCount(totalCount);
            int totalPage = page.getTotalPage();//获取的同时也设置了
            //对首页末页进行控制
            if (currentPage < 1) {
                currentPage = 1;//当前页不能小于首页
            } else if (currentPage > totalPage) {
                currentPage = totalPage;//当前页不能大于末页
            }
            //设置当前页码
            page.setCurrentPage(currentPage);
            return page;
        }
        return page;
    }

}