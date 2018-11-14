import java.io.IOException;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		DatagramSocket clientSocket = new DatagramSocket();
		InetAddress IPServer = InetAddress.getByName("localhost");
		byte[] sendData;
		String msg = "";

		while (true && !msg.equals("end")) {
			msg = in.nextLine();
			if (!msg.equals("end")) {
				sendData = (msg).getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPServer, 5000);
				long t1 = System.nanoTime();
				clientSocket.send(sendPacket);
				byte[] receiveData = new byte[1];
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				clientSocket.receive(receivePacket);
				long t2 = System.nanoTime();
				System.out.println("T1 " + (t1 / 1000));
				System.out.println("T2 " + (t2 / 1000));
				System.out.println("RTT " + (t2 - t1) / 1000);
			}
		}
		clientSocket.close();
	}

}
