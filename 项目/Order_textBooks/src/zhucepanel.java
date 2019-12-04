//注册界面
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class zhucepanel extends JFrame{

	JFrame jf = new JFrame("注册");
	JLabel message = new JLabel("注册中");
	JLabel username_t1 = new JLabel("用户名：");
	JLabel password_t1 = new JLabel("密码：");
	JLabel password_t2 = new JLabel("再次确认密码：");
	JTextField username_s2 = new JTextField();
	JPasswordField password_s1 = new JPasswordField();
	JPasswordField password_s2 = new JPasswordField();
	JButton login = new JButton("确认");
	JButton cancer = new JButton("取消");
	
	public zhucepanel() {
		jf.setLayout(null);
		jf.setSize(300, 250);
		jf.setLocation(300, 300);
		jf.setVisible(true);
		
		username_t1.setSize(100, 20);
		username_t1.setLocation(20, 30);
		jf.add(username_t1);
		
		password_t1.setSize(100, 20);
		password_t1.setLocation(20, 70);
		jf.add(password_t1);
		
		password_t2.setSize(100, 20);
		password_t2.setLocation(20, 110);
		jf.add(password_t2);
		
		username_s2.setSize(100, 20);
		username_s2.setLocation(140, 30);
		jf.add(username_s2);
		
		password_s1.setSize(100, 20);
		password_s1.setLocation(140, 70);
		jf.add(password_s1);
		
		password_s2.setSize(100, 20);
		password_s2.setLocation(140, 110);
		jf.add(password_s2);
		
		login.setSize(60, 20);
		login.setLocation(30, 150);
		cancer.setSize(60, 20);
		cancer.setLocation(160, 150);
		jf.add(login);
		jf.add(cancer);
		
		message.setSize(100, 20);
		message.setLocation(30, 180);
		jf.add(message);
		
		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
               if(password_s1.getText().equals(password_s2.getText())) {
            	   String s1 = password_s1.getText();
            	   String s2 = username_s2.getText();
            	   User user = new User(s2,s1);
            	   new startPanel().ud.regist(user);
            	   jf.dispose();
               }
               else {
            	   message.setText("两次密码不一致");
               }
			}
		});
		
		cancer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
               jf.dispose();
               new startPanel();
			}
		});
	}		
}
