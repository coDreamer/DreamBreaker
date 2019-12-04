import java.util.ArrayList;

//注册登录实现类
public class UserDaoImpl implements UserDao{
    //登录用户信息存储
	private static ArrayList<User> list = new ArrayList<User>();
	
	@Override
	public boolean login(String name, String password) {
		User user1 = new User("sa","123");
		list.add(user1);
		boolean result = false;//变量返回确定是否登录
		for(User user: list) {//遍历list是否含有登录请求用户
			if(user.getName().equals(name) &&
				user.getPassword().equals(password)) {
				result = true;
				break;
			}
		}
		return result;
	}

	@Override
	public void regist(User user) {
		list.add(user);	
	}

}
