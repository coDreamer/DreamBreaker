//��ͨ�û�����
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class yhpanel implements ActionListener{

	JFrame jf = new JFrame("��ͨ�û�����");
	ImageIcon image = new ImageIcon("./img/bg.png");
	JLabel jl = new JLabel(image);
	
	JButton jb1 = new JButton("��Ʒ");
	JButton jb2 = new JButton("����");
	JButton jb3 = new JButton("�˳�");
	
	Connection ct = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public yhpanel() throws Exception {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			ct = DriverManager.getConnection("jdbc:sqlserver://192.168.137.1;"
					+ "databaseName = textbook", "gg", "123");
		}catch (Exception e) {
			throw e;
		}
		
		jf.setLayout(null);
		jf.setSize(300, 190);
		jf.setLocation(300, 200);
		jf.setVisible(true);
		
		jl.setBounds(120, 20, 140, 110);
		jf.add(jl);
		
		jb1.setBounds(30, 20, 60, 20);
		jf.add(jb1);
		jb1.addActionListener(this);
		jb2.setBounds(30, 60, 60, 20);
		jf.add(jb2);
		jb2.addActionListener(this);
		jb3.setBounds(30, 100, 60, 20);
		jf.add(jb3);
		jb3.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent event) {
		Object source=event.getSource();
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		List<String> list3 = new ArrayList<String>();
		List<String> list4 = new ArrayList<String>();
		List<String> list5 = new ArrayList<String>();
		List<String> list6 = new ArrayList<String>();
		if(source==jb1) {
			try {				
				ps =ct.prepareStatement("select * from kucun");
				rs = ps.executeQuery();
				while(rs.next()) {
					list1.add(rs.getString(1).trim());
					list2.add(rs.getString(2).trim());
					list3.add(rs.getString(3).trim());
					list4.add(rs.getString(4).trim());
					list5.add(rs.getString(5).trim());
					list6.add(rs.getString(6).trim());					
				}
				if(list1 != null) {
					for(int i=0;i<list1.size();i++) {
						System.out.println("������"+list1.get(i));
						System.out.println("������"+list2.get(i));
						System.out.println("���ߣ�"+list3.get(i));
						System.out.println("����ʱ�䣺"+list4.get(i));
						System.out.println("�����磺"+list5.get(i));
						System.out.println("���ۣ�"+list6.get(i));
						System.out.println();
					}
				}				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(source==jb2) {
			System.out.println("������Ҫ�����������");
			Scanner sc = new Scanner(System.in);
			String a = sc.next();
			System.out.println("������Ҫ�����������");
			String b = sc.next();
			System.out.println("�����빺��İ༶��");
			String c = sc.next();
			System.out.println("�����빺���ˣ�");
			String d = sc.next();
			int e = 0;
			try {
				ps =ct.prepareStatement("select * from kucun");
				rs = ps.executeQuery();
				while(rs.next()) {
					list1.add(rs.getString(1).trim());
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			if(list1.contains(a)) {
				try {				
					//��ȡ��ǰ���������
					ps =ct.prepareStatement("select * from dinggou");
					rs = ps.executeQuery();
					while(rs.next()) {					
						e = (e<=rs.getInt(5)?rs.getInt(5):e);
					}
					//���������¼�¼
					ps =ct.prepareStatement("insert into dinggou(shuming,number,class"
							+ ",dgren,no) values (?,?,?,?,?)");
					ps.setString(1, a);
					ps.setString(2, b);
					ps.setString(3, c);
					ps.setString(4, d);
					ps.setInt(5, e+1);
					ps.executeUpdate();
					System.out.println("���µ���");
					//��Ӧ��������ˢ�ºͳ��������¼�¼
					ps =ct.prepareStatement("update kucun set number = number-?"
							+ " where shuming=?");
					ps.setString(1, b);
					ps.setString(2, a);
					ps.executeUpdate();
					ps =ct.prepareStatement("insert into chuku(shuming,number,ckshijian"
							+ ") values (?,?,?)");
					Date time= new java.sql.Date(new java.util.Date().getTime());
					ps.setString(1, a);
					ps.setString(2, b);
					ps.setDate(3, time);
					ps.executeUpdate();					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}else {
				System.out.println(list1);
				System.out.println("������û�У��޷�����");
				sc.close();
				return;
			}
			sc.close();
		}else {
			jf.dispose();
		}
	}
	
}
