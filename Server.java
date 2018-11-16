import java.io.IOException;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;

public class Server {

	public static void main(String[] args) throws IOException {
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
			if(msgS.contains("Ola")) {
				resp = "Ola, o que desejas?\n1. Pesquisas\n2.Armas\n3.Lula";
			}if(msgS.contains("1")) {
				resp = "Ninguem vai ganhar nem vai perder.\nnem quem ganhar nem quem perder vai ganhar ou perder"
						+ "\nvai todo mundo perder.";
			}if(msgS.contains("2")) {
				resp = "Pistola Tauros 12x de 39,90 na Casa Bahia \nmas so ate amanhã";
			}if(msgS.contains("3")) {
				resp = "Lula ladrão, roubou meu coração";
			}
			sendData = (resp).getBytes();
			System.out.println(msgS);
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientIP, port);
			serverSocket.send(sendPacket);
		}

	}

}
