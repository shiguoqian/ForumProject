import bean.User;
import dao.IUserDao;
import dao.imp.UserDaoImp;
import service.IUserService;
import service.imp.UserServiceImp;

public class Test {
	public static void main(String[] args) {
		IUserService ius = new UserServiceImp();
		User user = new User("eds", "1234");
		ius.insertUser(user);
	}
}
