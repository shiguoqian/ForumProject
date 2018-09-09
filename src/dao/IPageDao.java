package dao;

import util.Page;

import java.util.List;

/**
 * 分页接口
 *
 * 史国茜
 */
public interface IPageDao {
    /**
     * 通过分页技术显示所有用户
     * @param page
     * @return
     */
    List<Object> getUserByPage(Page page);

    /**
     * 通过分页技术显示某用户帖子
     * @param page
     * @return
     */
    List<Object> getPostByPage(Page page, int uId);

    /**
     * 通过分页技术显示某用户收藏贴
     * @param uId
     * @return
     */
    List<Object> getCollectByPage(Page page,int uId);

    /**
     * 通过分页技术展示所有帖子
     * @param page
     * @return
     */
    List<Object> getPostByPage(Page page);

    /**
     * 获取用户总条数
     * @return
     */
    int getUserTotalCount();

    /**
     * 获取用户帖子总条数
     * @return
     */
    int getPostTotalCount();

    /**
     * 获取帖子总条数
     */
    int getPostTotalCount(int uId);

    /**
     * 获取收藏贴总条数
     * @param uId
     * @return
     */
    int getCollectTotalCount(int uId);

}
