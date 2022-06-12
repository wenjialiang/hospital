package hospital_sever;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;
import java.sql.*;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class DBUtil extends JFrame {
	// 连接
	private Connection con = null;
	public String driver = "com.mysql.cj.jdbc.Driver";
	public String url = "jdbc:mysql://127.0.0.1:3306/hostipal?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8";
	public String username;
	public String password;

	JButton loginJButton = new JButton("登录");
	JButton cancelJButton = new JButton("取消");

	JLabel accountJLabel = new JLabel("账号：");
	JLabel passwordJLabel = new JLabel("密码：");

	static JTextField userIdJTextField = new JTextField();
	static JPasswordField passwordJPasswordField = new JPasswordField();

	public void getUsername() {
		System.out.println("请输入用户名");
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		username = s;
	}

	public void getPassword() {
		System.out.println("请输入密码");
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		password = s;

	}

	// 获取连接
	public Connection getConnection() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			System.out.println("连接成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("获取连接失败:" + e.getMessage());
		}
		return con;
	}

	// 关闭连接
	public void close() {
		try {
			if (con != null) {
				con.close();
			}
			con = null;
			System.out.println("数据库连接关闭");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}