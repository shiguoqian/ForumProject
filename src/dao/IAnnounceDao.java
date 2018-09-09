package dao;

import java.util.List;

import bean.Announce;

public interface IAnnounceDao {
	
	List<Announce> getAllAnnounce();//获取所有的公告
	int insertAnnounce(Announce announce);//添加公告
	int delAnnounceById(int annId);//删除公告
	

}
