package dao;

import java.util.List;

import bean.Advise;

public interface IAdviseDao {
	List<Advise> getAllAdvise();//获取所有建议:管理员
	int  insertAdvise(Advise advise);//添加建议
	List<Advise> getAllAdviseById(int uId);//获取用户所有的发表的建议

}
