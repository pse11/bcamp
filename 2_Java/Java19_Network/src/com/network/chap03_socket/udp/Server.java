package com.network.chap03_socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Server {
	//데이터 발신
	public static void main(String[] args) throws IOException {
		//소켓 생성
		DatagramSocket ds = new DatagramSocket();
		System.out.println("서버입니다.");
		
		//보내고자 하는 data 준비
		byte[] buff = "테스트 입니다.".getBytes(); //string값을 byte배열로 만든다.
		
		//datagramPacket 생성
		DatagramPacket sendPac = 
				new DatagramPacket(buff, buff.length,InetAddress.getByName("localhost"),9999);
		
		//전송 
		ds.send(sendPac);//소켓으로 내보내준다.
		
		//종료
		ds.close();
		ds.disconnect();
	}
}
