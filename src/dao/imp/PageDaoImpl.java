package dao.imp;

import bean.Post;
import bean.User;
import dao.IPageDao;
import util.DBUtil;
import util.Page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页实现类
 *
 * 史国茜
 */
public class PageDaoImpl implements IPageDao {
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet rs = null;

    /**
     * 分页显示所有用户
     * @param page
     * @return
     */
    @Override
    public List<Object> getUserByPage(Page page){
        connection = DBUtil.getConn();
        List<Object> userList = new ArrayList<>();
        String sql = "select * from ("+"select rownum r ,t.* from (" + "select u.* from users u order by u_id asc ) t )" +
                "where r >=? and r<=?";
        int begin = (page.getCurrentPage()-1)*page.getPageSize();
        int end = page.getCurrentPage()*page.getPageSize();
        Object[] objects = {begin,end};
        rs = DBUtil.executeQuery(sql,objects);
        try {
            while (rs.next()){
                userList.add(new User(rs.getInt("u_id"),rs.getString("u_name"),rs.getString("u_pass"),
                        rs.getString("u_sex"),rs.getDate("reg_time"),rs.getDate("login_time"),
                        rs.getString("u_email"),rs.getString("u_phone"),rs.getInt("u_post"),rs.getInt("u_collect"),
                        rs.getInt("u_atte"),rs.getInt("u_fans"),rs.getInt("u_rank"),rs.getString("u_nickname"),
                        rs.getString("u_city")));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(connection,statement, rs);
        }
        return userList;
    }

    /**
     * 分页显示id为uId的用户帖子
     * @param page
     * @param uId
     * @return
     */
    @Override
    public List<Object> getPostByPage(Page page, int uId) {
        connection = DBUtil.getConn();
        List<Object> postList = new ArrayList<>();
        String sql = "select * from ("+"select rownum r ,t.* from (" + "select p.* from post p where u_id = ? order by u_id asc ) t )" +
                "where r >=? and r<=?";
        int begin = (page.getCurrentPage()-1)*page.getPageSize();
        int end = page.getCurrentPage()*page.getPageSize();
        Object[] objects = {uId,begin,end};
        rs = DBUtil.executeQuery(sql,objects);
        try {
            while (rs.next()) {
                postList.add(new Post(rs.getInt("p_id"), uId, rs.getString("p_title"),
                        rs.getString("p_content"), rs.getInt("p_check"), rs.getDate("p_time"), rs.getInt("p_isfine"),
                        rs.getInt("p_istop"), rs.getInt("like_num"), rs.getString("p_browser"),
                        rs.getString("p_version"), rs.getString("p_type"), rs.getString("p_project"),
                        rs.getString("p_experience")));
            }
            for (Object object:postList){
                System.out.println(object.toString());
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(connection,statement, rs);
        }
        return postList;
    }

    @Override
    public List<Object> getCollectByPage(Page page, int uId) {
        connection = DBUtil.getConn();
        List<Object> postList = new ArrayList<>();
        String sql = "select * from ("+"select rownum r ,t.* from (select * from post where p_id IN (select p_id from collect where u_id=?) order by p_id asc ) t )" +
                "where r >=? and r<=?";
        int begin = (page.getCurrentPage()-1)*page.getPageSize();
        int end = page.getCurrentPage()*page.getPageSize();
        Object[] objects = {uId,begin,end};
        rs = DBUtil.executeQuery(sql,objects);
        try {
            while (rs.next()) {
                postList.add(new Post(rs.getInt("p_id"), uId, rs.getString("p_title"),
                        rs.getString("p_content"), rs.getInt("p_check"), rs.getDate("p_time"), rs.getInt("p_isfine"),
                        rs.getInt("p_istop"), rs.getInt("like_num"), rs.getString("p_browser"),
                        rs.getString("p_version"), rs.getString("p_type"), rs.getString("p_project"),
                        rs.getString("p_experience")));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(connection,statement, rs);
        }
        return postList;
    }

    /**
     * 分页显示所有用户帖子
     * @param page
     * @return
     */
    @Override
    public List<Object> getPostByPage(Page page) {
        connection = DBUtil.getConn();
        List<Object> postList = new ArrayList<>();
        String sql = "select * from ("+"select rownum r ,t.* from (" + "select p.* from post p order by u_id asc ) t )" +
                "where r >=? and r<=?";
        int begin = (page.getCurrentPage()-1)*page.getPageSize();
        int end = page.getCurrentPage()*page.getPageSize();
        Object[] objects = {begin,end};
        rs = DBUtil.executeQuery(sql,objects);
        try {
            while (rs.next()) {
                postList.add(new Post(rs.getInt("p_id"),rs.getInt("u_id"), rs.getString("p_title"),
                        rs.getString("p_content"), rs.getInt("p_check"), rs.getDate("p_time"), rs.getInt("p_isfine"),
                        rs.getInt("p_istop"), rs.getInt("like_num"), rs.getString("p_browser"),
                        rs.getString("p_version"), rs.getString("p_type"), rs.getString("p_project"),
                        rs.getString("p_experience")));
            }
            for (Object object:postList){
                System.out.println(object.toString());
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(connection,statement, rs);
        }
        return postList;
    }

    /**
     * 获取用户总数
     * @return
     */
    @Override
    public int getUserTotalCount() {
        connection = DBUtil.getConn();
        int count = 0;
        String sql = "select count(*) from users";
        Object[] objects = {};
        rs = DBUtil.executeQuery(sql,objects);
        try {
            if (rs.next()){
                count = rs.getInt(1);
                System.out.println(count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(connection,statement, rs);
        }
        return count;
    }

    /**
     * 获取帖子总数
     * @return
     */
    @Override
    public int getPostTotalCount() {
        connection = DBUtil.getConn();
        int count = 0;
        String sql = "select count(*) from post";
        Object[] objects = {};
        rs = DBUtil.executeQuery(sql,objects);
        try {
            if (rs.next()){
                count = rs.getInt(1);
                System.out.println(count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(connection,statement, rs);
        }
        return count;
    }

    /**
     * 获取某用户的所有帖子
     * @param uId
     * @return
     */
    @Override
    public int getPostTotalCount(int uId) {
        connection = DBUtil.getConn();
        int count = 0;
        String sql = "select count(*) from post where u_id = ?";
        Object[] objects = {uId};
        rs = DBUtil.executeQuery(sql,objects);
        try {
            if (rs.next()){
                count = rs.getInt(1);
                System.out.println(count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(connection,statement, rs);
        }
        return count;
    }

    @Override
    public int getCollectTotalCount(int uId) {
        connection = DBUtil.getConn();
        int count = 0;
        String sql = "select count(*) from post where p_id IN (select p_id from collect where u_id=?)";
        Object[] objects = {uId};
        rs = DBUtil.executeQuery(sql,objects);
        try {
            if (rs.next()){
                count = rs.getInt(1);
                System.out.println(count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(connection,statement, rs);
        }
        return count;
    }

}
