//登陆界面
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class startPanel extends JFrame{
    
	String user = null;
	String password = null;
	UserDao ud = new UserDaoImpl();
	
	JFrame jf = new JFrame("教材预定系统");
	JLabel username_1 = new JLabel("用户名：");
	JLabel password_1 = new JLabel("密码：");
	JLabel message = new JLabel("欢迎使用该系统！");
	JTextField username_2 = new JTextField();
	JPasswordField password_2 = new JPasswordField();
	JButton login = new JButton("登录");
	JButton register = new JButton("注册");
	
	public startPanel() {
				
		jf.setLayout(null);
		jf.setSize(300, 250);
		jf.setLocation(300, 300);
		jf.setVisible(true);
		
		username_1.setSize(60, 20);
		username_1.setLocation(20, 70);
		password_1.setSize(60, 20);
		password_1.setLocation(20, 110);
		jf.add(username_1);
		jf.add(password_1);
		
		username_2.setSize(100, 20);
		username_2.setLocation(90, 70);
		password_2.setSize(100, 20);
		password_2.setLocation(90, 110);
		jf.add(username_2);
		jf.add(password_2);
		
		message.setSize(200, 20);
		message.setLocation(100, 20);
		jf.add(message);
		
		login.setSize(60, 20);
		login.setLocation(60, 160);
		register.setSize(60, 20);
		register.setLocation(140, 160);
		jf.add(login);
		jf.add(register);
		
		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                user = username_2.getText();
                password = password_2.getText();
                if(user.equals("sa")) {
                	boolean re = ud.login(user, password);
                    if(re) {
                    	try {
							new glypanel();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
                    	jf.dispose();
                    }
                    else {
                    	message.setText("账户或密码错误");
                    }
                }else {
                	boolean re = ud.login(user, password);
                    if(re) {
                    	try {
							new yhpanel();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
                    	jf.dispose();
                    }
                    else {
                    	message.setText("账户或密码错误");
                    }
                }
			}
		});//登录操作
		
		register.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
               jf.dispose();
               new zhucepanel();
			}
		});//注册操作
		
	}
	
	public static void main(String[] args) {
		startPanel t = new startPanel();		
	}

}
