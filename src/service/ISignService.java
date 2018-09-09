package service;

public interface ISignService {
	boolean addSignTime(int id);//是否成功签到
	boolean isSign(int id); //是否可以签到
	int showSignTimes(int id); //查看签到总数
	
}
