//µÇÂ¼×¢²á½Ó¿Ú
public interface UserDao{
	public abstract boolean login(String name,String password);
	public abstract void regist(User user);
}