package hostipal_client;

import java.io.IOException;
import java.net.*;
import java.util.*;

public class UDPClient {

	String ip = "localhost";
	int send_port = 54322;
	int recv_port = 54321;
	DatagramSocket send_socket = null;
	DatagramSocket recv_socket = null;

	UDPClient() {

	}

	UDPClient(String ip, int sport, int rport) throws Exception {
		this.ip = ip;
		this.send_port = sport;
		this.recv_port = rport;
		send_socket = new DatagramSocket();
		recv_socket = new DatagramSocket(recv_port, InetAddress.getByName(ip));
	}

	public void Send(String send_msg) throws Exception {

		// 发送给服务端
		byte[] sbuf = send_msg.getBytes();
		DatagramPacket resp = new DatagramPacket(sbuf, sbuf.length, InetAddress.getByName(ip), send_port);
		send_socket.send(resp);
	}

	public String Recive() throws IOException {
		// 接受数据
		byte[] rbuf = new byte[1024];
		DatagramPacket data = new DatagramPacket(rbuf, 1024);
		recv_socket.receive(data);
		String msg = new String(rbuf);
		return msg;
	}

	public void close() {
		send_socket.close();
		recv_socket.close();
	}

}
