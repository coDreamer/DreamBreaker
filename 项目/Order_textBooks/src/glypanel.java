//管理员界面
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;

public class glypanel extends JFrame implements ActionListener{

	static int operate = 0;
	Connection ct = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	JFrame jf = new JFrame("管理员界面");
	
	JButton jb1 = new JButton("库存表");
	JButton jb2 = new JButton("出库表");
	JButton jb3 = new JButton("入库表");
	JButton jb4 = new JButton("订单表");
	JButton jb5 = new JButton("工作人员表");
	JButton jb6 = new JButton("退出");
	JButton jb7 = new JButton("修改数据");
	
	public glypanel() throws Exception{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			ct = DriverManager.getConnection("jdbc:sqlserver://192.168.137.1;"
					+ "databaseName = textbook", "sa", "123");
		}catch (Exception e) {
			throw e;
		}
		jf.setLayout(null);
		jf.setSize(300, 190);
		jf.setLocation(300, 200);
		jf.setVisible(true);
		
		jb1.setBounds(30, 20, 100, 20);
		jf.add(jb1);
		jb1.addActionListener(this);
		jb2.setBounds(150, 20,100, 20);
		jf.add(jb2);
		jb2.addActionListener(this);
		jb3.setBounds(30, 50,100, 20);
		jf.add(jb3);
		jb3.addActionListener(this);
		jb4.setBounds(150, 50,100, 20);
		jf.add(jb4);
		jb4.addActionListener(this);
		jb5.setBounds(30, 80,100, 20);
		jf.add(jb5);
		jb5.addActionListener(this);
		jb6.setBounds(150, 80,100, 20);
		jf.add(jb6);
		jb6.addActionListener(this);
		jb7.setBounds(90, 110,100, 20);
		jf.add(jb7);
		jb7.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent event){
		Object source=event.getSource();
		if(source==jb1) {
			operate = 1;
			try {
				ps =ct.prepareStatement("select * from kucun");
				rs = ps.executeQuery();
				System.out.println("书名            ");
				while(rs.next()) {
					String s1 = rs.getString(1);
					int s2 = rs.getInt(2);
					String s3 = rs.getString(3);
					Date s4 = rs.getDate(4);
					String s5= rs.getString(5);
					Float s6 = rs.getFloat(6);
					
					System.out.println("书名："+s1);
					System.out.println("数量："+s2);
					System.out.println("作者："+s3);
					System.out.println("出版时间："+s4);
					System.out.println("出版社："+s5);
					System.out.println("定价："+s6);
					System.out.println();
				}				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(source==jb2) {
			operate = 2;
			try {
				ps =ct.prepareStatement("select * from chuku");
				rs = ps.executeQuery();
				while(rs.next()) {
					String s1 = rs.getString(1);
					int s2 = rs.getInt(2);
					String s3= rs.getString(3);
					
					System.out.println("书名："+s1);
					System.out.println("数量："+s2);
					System.out.println("出库时间："+s3);
					System.out.println();
				}				
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}else if(source==jb3){
			operate = 3;
			try {
				ps =ct.prepareStatement("select * from ruku");
				rs = ps.executeQuery();
				while(rs.next()) {
					String s1 = rs.getString(1);
					int s2 = rs.getInt(2);
					String s3= rs.getString(3);
					Date s4 = rs.getDate(4);
					
					System.out.println("书名："+s1);
					System.out.println("数量："+s2);
					System.out.println("检验员："+s3);
					System.out.println("入库时间："+s4);
					System.out.println();
				}				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(source==jb4){
			operate = 4;
			try {
				ps =ct.prepareStatement("select * from dinggou");
				rs = ps.executeQuery();
				while(rs.next()) {
					String s1 = rs.getString(1);
					int s2 = rs.getInt(2);
					String s3= rs.getString(3);
					String s4 = rs.getString(4);
					int s5 = rs.getInt(5);
					
					System.out.println("书名："+s1);
					System.out.println("数量："+s2);
					System.out.println("班级："+s3);
					System.out.println("订购人："+s4);
					System.out.println("订单号："+s5);
					System.out.println();
				}				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(source==jb5){
			operate = 5;
			try {
				ps =ct.prepareStatement("select * from gzryuan");
				rs = ps.executeQuery();
				while(rs.next()) {
					String s1 = rs.getString(1);
					String s2 = rs.getString(2);
					String s3= rs.getString(3);					
					
					System.out.println("检验员："+s1);
					System.out.println("姓名："+s2);
					System.out.println("电话："+s3);
					System.out.println();
				}				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(source==jb6){
			jf.dispose();
			try {
				close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			if(operate != 0) {
				switch(operate) {
				case 1:{
					try {
						caozuo1();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					operate = 0;
					break;
				}
				case 3:{
					try {
						caozuo3();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					operate = 0;
					break;
				}
				case 4:{
					try {
						caozuo4();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					operate = 0;
					break;
				}
				case 5:{
					try {
						caozuo5();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					operate = 0;
					break;
				}
				default:System.out.println("无权限修改表！");operate = 0;break;
				}					
			}else {
				System.out.println("无表格，无法修改数据！");
			}
		}
	}

	public void caozuo1() throws SQLException{
		System.out.println("请输入要修改数据的书籍名称：");
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		System.out.println("修改后的数量：");
		String b = sc.next();
		ps =ct.prepareStatement("update kucun set number=?"+
			    " where shuming=?");
		ps.setString(1, b);
		ps.setString(2, a);
		ps.execute();
		System.out.println("数据更新完成！");
		sc.close();
	}
	
	public void caozuo3() throws SQLException{
		System.out.println("1.插入入库记录  2.修改入库记录");
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		if(a.equals("1")) {
			System.out.println("输入书名：");
			String a1 = sc.next();
			System.out.println("输入数量：");
			String a2 = sc.next();
			System.out.println("输入检验人：");
			String a3 = sc.next();
			System.out.println("输入入库日期(格式为xxxx.xx.xx)：");
			String a4 = sc.next();
			java.sql.Date a5 = java.sql.Date.valueOf(a4);
			ps =ct.prepareStatement("insert into ruku(shuming,number,jyr,rkshijian)"
					+" values(?,?,?,?)");
			ps.setString(1, a1);
			ps.setString(2, a2);
			ps.setString(3, a3);
			ps.setDate(4, a5);
			ps.execute();
			System.out.println("数据插入成功！");
			//更新数据库库存表的信息
			ps =ct.prepareStatement("select * from kucun");
			List<String> list = new ArrayList<String>();
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(rs.getString(1).trim());
			}
			if(list.contains(a1)) {
				ps =ct.prepareStatement("update kucun set number=number+?"
						+" where shuming=?");
				ps.setString(1, a2);
				ps.setString(2, a1);
				ps.executeUpdate();
			}else {
				System.out.println("库存数据更新，输入书名：");
				a1 = sc.next();
				System.out.println("输入数量：");
				a2 = sc.next();
				System.out.println("输入作者：");
				a3 = sc.next();
				System.out.println("输入出版日期(格式为xxxx.xx.xx)：");
				a4 = sc.next();
				a5 = java.sql.Date.valueOf(a4);
				System.out.println("输入出版社：");
				String a6 = sc.next();
				System.out.println("输入定价：");
				Float a7 = sc.nextFloat();
				ps =ct.prepareStatement("insert into kucun(shuming,number,zuozhe"
						+ ",cbshijian,cbshe,price) values("
						+"?,?,?,?,?,?)");
				ps.setString(1, a1);
				ps.setString(2, a2);
				ps.setString(3, a3);
				ps.setDate(4, a5);
				ps.setString(5, a6);
				ps.setFloat(6, a7);
				ps.executeUpdate();
			}	
		}else if(a.equals("2")){
			System.out.println("入库信息更新，输入要更新的书名：");
			String m = sc.next();
			System.out.println("输入数量：");
			String n = sc.next();
			System.out.println("输入检验人：");
			String x = sc.next();
			ps =ct.prepareStatement("update ruku set shuming=?,number=?,jyr=?"
					+" where shuming=?");
			ps.setString(1, m);
			ps.setString(2, n);
			ps.setString(3, x);
			ps.setString(4, m);
			ps.executeUpdate();
		}
		sc.close();
	}
	
    public void caozuo4() throws SQLException{
    	System.out.println("请输入要删除的订单号：");
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		ps =ct.prepareStatement("select * from dinggou where no=?");
		ps.setString(1, a);
		rs = ps.executeQuery();
		String b = null;
		String c = null;
		while(rs.next()) {
			b = rs.getString(1);
			c = rs.getString(2);
		}
		ps =ct.prepareStatement("delete from dinggou where no=?");
		ps.setString(1, a);
		ps.execute();
		System.out.println("删除成功！");
		sc.close();
		ps =ct.prepareStatement("update kucun set number=number+? where"
				+ " shuming=?");
		ps.setString(1, c);
		ps.setString(2, b);
		ps.execute();
	}
	
	public void caozuo5() throws SQLException {
    	System.out.println("1.插入  2.删除  3.修改");
		Scanner sc = new Scanner(System.in);
		String i = sc.next();
		if(i.equals("1")) {
			System.out.println("输入编号：");
			String a = sc.next();
			System.out.println("输入姓名：");
			String b = sc.next();
			System.out.println("输入电话：");
			String c = sc.next();
			ps =ct.prepareStatement("insert into gzryuan"+"(jyr,name,tel)"
			    +"values("+"?,?,?)");
			ps.setString(1, a);
			ps.setString(2, b);
			ps.setString(3, c);
			ps.execute();
			System.out.println("插入数据完成！");
		}else if(i.equals("2")) {
			System.out.println("无权限删除检验员信息！");
		}else if(i.equals("3")) {
			System.out.println("输入要修改人员的编号：");
			String a = sc.next();
			System.out.println("输入姓名：");
			String b = sc.next();
			System.out.println("输入电话：");
			String c = sc.next();
			ps =ct.prepareStatement("update gzryuan set name=?"+
			    ",tel=? where "+"jyr=?");
				ps.setString(1, b);
				ps.setString(2, c);
				ps.setString(3, a);
				ps.execute();
				System.out.println("数据更新完成！");
		}
		sc.close();
	}
		
	public void close() throws Exception{
		if(this.ct!=null) {
			try {
				this.ct.close();
			}catch(Exception e) {
				throw e;
			}
		}
	}//关闭数据库连接
}
