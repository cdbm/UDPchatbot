
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		DatagramSocket serverSocket = new DatagramSocket(3000);
		byte[] sendData;
		InetAddress clientIP;
		int port;
		String resp = "";
		while (true) {
			byte[] receiveData = new byte[100];
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			serverSocket.receive(receivePacket);
			clientIP = receivePacket.getAddress();
			port = receivePacket.getPort();
			String msgS = new String (receiveData, "UTF-8");
			System.out.println(msgS);
			resp = in.nextLine();
			sendData = (resp).getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientIP, port);
			serverSocket.send(sendPacket);
		}

	}

}
