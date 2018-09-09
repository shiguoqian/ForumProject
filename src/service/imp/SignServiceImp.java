package service.imp;
import java.text.SimpleDateFormat;
import java.util.Date;
import dao.imp.SignDaoImp;
import service.ISignService;

public class SignServiceImp implements ISignService {
	SignDaoImp dao=new SignDaoImp();
	@Override
	public boolean addSignTime(int id) {
		int time=dao.addSignTime(id);
		if(time>0){
			return true;
		}else{
		return false;
		}
	}
	@Override
	public boolean isSign(int id) {
		String time=dao.getSignTime(id);
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY/MM/dd");
		String df=sdf.format(date);
		 // SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	       // String form=sd.format(date);
		if(df.equals(time)){
			System.out.println("已经签到过了");
			return false; //说明签到过了
		}
		else{
			System.out.println("签到成功");
		SignServiceImp	service=new SignServiceImp(); 
		boolean f=	service.addSignTime(id);
		return f; //说明可以签到
		}
	}
	@Override
	public int showSignTimes(int id) {
		
		return dao.showSignTimes(id);
	}
}
