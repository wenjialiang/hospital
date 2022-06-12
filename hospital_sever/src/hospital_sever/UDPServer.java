package hospital_sever;

import java.net.*;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.StringTokenizer;

public class UDPServer {

	int send_port = 5150;
	int recv_port = 5253;
	String ip = "localhost";

	public UDPServer() {

	}

	public UDPServer(String ip, int sport, int rport) {
		this.ip = ip;
		this.send_port = sport;
		this.recv_port = rport;
	}

	public void Lisent() throws Exception {

		// 创建发送和接收的UDPsocket
		DatagramSocket send_socket = new DatagramSocket();
		DatagramSocket recv_socket = new DatagramSocket(recv_port, InetAddress.getByName(ip));
		DBUtil dbUtil = new DBUtil();
		dbUtil.getUsername();
		dbUtil.getPassword();
		Connection con = (Connection) dbUtil.getConnection();
		String cmsg = new String();

		// 接收数据的DatagramPacket对象
		byte[] buf = new byte[1024];
		DatagramPacket data = new DatagramPacket(buf, 1024);
		while (true) {
			// 接受数据

			recv_socket.receive(data);
			String msg = new String(buf);
			System.out.println("[服务端] 接受到客户端信息: " + msg);
			StringTokenizer st = new StringTokenizer(msg, ",");
			String b = st.nextToken();
			String s1 = new String();

			switch (b) {
			case "a":
				break;
			case "b":
				s1 = "select * from doctor where iddoctor=?";
				PreparedStatement pStatement = con.prepareStatement(s1);
				pStatement.setString(1, st.nextToken());
				ResultSet rSet = pStatement.executeQuery();
				while (rSet.next()) {
					cmsg = rSet.getString("iddoctor") + "," + rSet.getString("namedoctor") + ","
							+ rSet.getString("sexdoctor") + "," + rSet.getString("agedoctor") + ","
							+ rSet.getString("titledoctor") + "," + rSet.getString("onudoctor");
				}
				break;
			case "c":
				s1 = "delete from doctor where iddoctor=?";
				PreparedStatement ps = con.prepareStatement(s1);
				ps.setString(1, st.nextToken());
				ps.executeUpdate();
				cmsg = "ok";
				break;
			case "d":
				s1 = "update doctor set namedoctor=?,sexdoctor=?,agedoctor=?,titledoctor=? ,titledoctor=? where iddoctor=?";
				PreparedStatement pStatement1 = con.prepareStatement(s1);

				pStatement1.setString(1, st.nextToken());
				pStatement1.setString(2, st.nextToken());
				pStatement1.setString(3, st.nextToken());
				pStatement1.setString(4, st.nextToken());
				pStatement1.setString(5, st.nextToken());
				pStatement1.setString(6, st.nextToken());
				pStatement1.executeUpdate();
				cmsg = "ok";

				break;
			case "e":
				s1 = "insert into doctor values(?,?,?,?,?,?)";
				PreparedStatement pStatement2 = con.prepareStatement(s1);

				pStatement2.setString(1, st.nextToken());
				pStatement2.setString(2, st.nextToken());
				pStatement2.setString(3, st.nextToken());
				pStatement2.setString(4, st.nextToken());
				pStatement2.setString(5, st.nextToken());
				pStatement2.setString(6, st.nextToken());
				pStatement2.executeUpdate();
				cmsg = "ok";
				break;
			case "b1":
				s1 = "select * from office where idoffice=?";
				PreparedStatement pStatement11 = con.prepareStatement(s1);
				pStatement11.setString(1, st.nextToken());
				ResultSet rSet1 = pStatement11.executeQuery();
				while (rSet1.next()) {
					cmsg = rSet1.getString("idoffice") + "," + rSet1.getString("nameoffice") + ","
							+ rSet1.getString("whereoffice") + "," + rSet1.getString("teloffice") + ","
							+ rSet1.getString("directorl");
				}
				break;
			case "c1":
				s1 = "delete from office where idoffice=?";
				PreparedStatement ps1 = con.prepareStatement(s1);

				ps1.setString(1, st.nextToken());
				ps1.executeUpdate();
				cmsg = "ok";
				break;
			case "d1":
				s1 = "update office set nameoffice=?,whereoffice=?,teloffice=?, directorl=? where idoffice=?";
				PreparedStatement pStatement4 = con.prepareStatement(s1);

				pStatement4.setString(1, st.nextToken());
				pStatement4.setString(2, st.nextToken());
				pStatement4.setString(3, st.nextToken());
				pStatement4.setString(4, st.nextToken());
				pStatement4.setString(5, st.nextToken());

				pStatement4.executeUpdate();
				cmsg = "ok";
				break;
			case "e1":
				s1 = "insert into office values(?,?,?,?,?)";
				PreparedStatement pStatement5 = con.prepareStatement(s1);

				pStatement5.setString(1, st.nextToken());
				pStatement5.setString(2, st.nextToken());
				pStatement5.setString(3, st.nextToken());
				pStatement5.setString(4, st.nextToken());
				pStatement5.setString(5, st.nextToken());

				pStatement5.executeUpdate();
				cmsg = "ok";
				break;
			case "b2":
				s1 = "select * from patient where idpatient=?";
				PreparedStatement pStatement6 = con.prepareStatement(s1);
				pStatement6.setString(1, st.nextToken());
				ResultSet rSet6 = pStatement6.executeQuery();
				while (rSet6.next()) {
					cmsg = rSet6.getString("idpatient") + "," + rSet6.getString("napatient") + ","
							+ rSet6.getString("sexpatient") + "," + rSet6.getString("agepatient") + ","
							+ rSet6.getString("ropatient") + "," + rSet6.getString("nadopa") + ","
							+ rSet6.getString("blopatient") + "," + rSet6.getString("diapatient") + ","
							+ rSet6.getString("idopatient");
				}
				break;
			case "c2":
				s1 = "delete from patient where idpatient=?";
				PreparedStatement ps7 = con.prepareStatement(s1);
				ps7.setString(1, st.nextToken());
				ps7.executeUpdate();
				cmsg = "ok";
				break;
			case "d2":
				s1 = "update patient set napatient=?,sexpatient=?,agepatient=?, ropatient=?, nadopa=?,blopatient=?, diapatient=?,idopatient=? where idpatient=?";
				PreparedStatement pStatement8 = con.prepareStatement(s1);

				pStatement8.setString(1, st.nextToken());
				pStatement8.setString(2, st.nextToken());
				pStatement8.setString(3, st.nextToken());
				pStatement8.setString(4, st.nextToken());
				pStatement8.setString(5, st.nextToken());
				pStatement8.setString(6, st.nextToken());
				pStatement8.setString(7, st.nextToken());
				pStatement8.setString(8, st.nextToken());
				pStatement8.setString(9, st.nextToken());

				pStatement8.executeUpdate();
				cmsg = "ok";
				break;
			case "e2":
				s1 = "insert into patient values(?,?,?,?,?,?,?,?,?)";
				PreparedStatement pStatement9 = con.prepareStatement(s1);

				pStatement9.setString(1, st.nextToken());
				pStatement9.setString(2, st.nextToken());
				pStatement9.setString(3, st.nextToken());
				pStatement9.setString(4, st.nextToken());
				pStatement9.setString(5, st.nextToken());
				pStatement9.setString(6, st.nextToken());
				pStatement9.setString(7, st.nextToken());
				pStatement9.setString(8, st.nextToken());
				pStatement9.setString(9, st.nextToken());

				pStatement9.executeUpdate();
				cmsg = "ok";
				break;
			}
			byte[] rbuf = cmsg.getBytes();
			// 发送响应信息
			InetAddress caddr = data.getAddress(); // 客户端ip
			// 创建发送数据的DatagramPacket对象 需要指定目标ip和端口
			DatagramPacket resp = new DatagramPacket(rbuf, rbuf.length, caddr, send_port);
			send_socket.send(resp);
		}

	}

	public static void main(String[] args) throws Exception {
		UDPServer server = new UDPServer("127.0.0.1", 5150, 5253);
		server.Lisent();
	}

}
