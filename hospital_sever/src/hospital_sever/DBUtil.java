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
	// ����
	private Connection con = null;
	public String driver = "com.mysql.cj.jdbc.Driver";
	public String url = "jdbc:mysql://127.0.0.1:3306/hostipal?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8";
	public String username;
	public String password;

	JButton loginJButton = new JButton("��¼");
	JButton cancelJButton = new JButton("ȡ��");

	JLabel accountJLabel = new JLabel("�˺ţ�");
	JLabel passwordJLabel = new JLabel("���룺");

	static JTextField userIdJTextField = new JTextField();
	static JPasswordField passwordJPasswordField = new JPasswordField();

	public void getUsername() {
		System.out.println("�������û���");
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		username = s;
	}

	public void getPassword() {
		System.out.println("����������");
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		password = s;

	}

	// ��ȡ����
	public Connection getConnection() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			System.out.println("���ӳɹ�");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("��ȡ����ʧ��:" + e.getMessage());
		}
		return con;
	}

	// �ر�����
	public void close() {
		try {
			if (con != null) {
				con.close();
			}
			con = null;
			System.out.println("���ݿ����ӹر�");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}