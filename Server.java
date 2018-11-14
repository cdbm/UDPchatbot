import java.io.IOException;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;

public class Server {

	public static void main(String[] args) throws IOException {
		DatagramSocket serverSocket = new DatagramSocket(5000);
		byte[] receiveData = new byte[1000];
		byte[] sendData;
		InetAddress clientIP;
		int port;
		while (true) {
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			serverSocket.receive(receivePacket);
			clientIP = receivePacket.getAddress();
			port = receivePacket.getPort();
			sendData = ("2").getBytes();
			String msgS = new String (receiveData, "UTF-8");
			System.out.println(msgS);
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientIP, port);
			serverSocket.send(sendPacket);
		}

	}

}
