import java.io.*;
import java.net.*;

class UDPServer {
	//byte change to int
	public static final int byteArrayToInt(byte[] bytes) {
		return (bytes[0] << 24) + (bytes[1] << 16) + (bytes[2] << 8) + bytes[3];
	}

	public static void main(String args[]) throws Exception {
		DatagramSocket serverSocket = new DatagramSocket(9090);
		System.out.println("Server Ready ...");
		int received = 0;
		int outoforder = 0 ;
		int previous = 0 ;
		while (true){
			DatagramPacket rcvdPkt = new DatagramPacket(new byte[4],4);
			serverSocket.receive(rcvdPkt);

			if(byteArrayToInt(rcvdPkt.getData())-previous!=1) outoforder++;
			previous = byteArrayToInt(rcvdPkt.getData());
			received++;
			System.out.println(String.valueOf(byteArrayToInt(rcvdPkt.getData())));
			System.out.println("Total received: " + String.valueOf(received));
			System.out.println("Total out of order : " + String.valueOf(outoforder));
		}
    }
}