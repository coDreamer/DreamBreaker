import java.util.ArrayList;

//ע���¼ʵ����
public class UserDaoImpl implements UserDao{
    //��¼�û���Ϣ�洢
	private static ArrayList<User> list = new ArrayList<User>();
	
	@Override
	public boolean login(String name, String password) {
		User user1 = new User("sa","123");
		list.add(user1);
		boolean result = false;//��������ȷ���Ƿ��¼
		for(User user: list) {//����list�Ƿ��е�¼�����û�
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
