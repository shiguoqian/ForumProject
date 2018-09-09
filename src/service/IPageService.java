package service;

import util.Page;

import java.util.List;

/**
 * 分页service
 *
 * 史国茜
 */
public interface IPageService {
    /**
     * 根据页面设置获取所有用户信息
     * @param page
     * @return
     */
    public List<Object> getUserByPage(Page page);

    /**
     * 获取全部帖子
     * @param page
     * @return
     */
    public List<Object> getPostByPage(Page page);

    /**
     * 根据用户id获取分页用户帖
     * @param page
     * @param uId
     * @return
     */
    public List<Object> getPostByPage(Page page, int uId);

    /**
     * 根据用户id虎丘分页收藏贴
     * @param page
     * @param uId
     * @return
     */
    public List<Object> getCollectByPage(Page page,int uId);

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

    /**
     * 设置页面(重载)
     * @param currentPageStr
     * @return
     */
    public Page setPage(String currentPageStr);

    public Page setPage(String currentPageStr, String limitStr);

    public Page setPage(String currentPageStr, int uId);

    public Page setPage(String currentPageStr,int uId,String flag);
}
