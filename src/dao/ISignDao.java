package dao;

public interface ISignDao {
	int addSignTime(int id); //添加签到数据
	
	String getSignTime(int id);	//查询签到的时间
	
	int showSignTimes(int id); //展示签到的次数	
}
