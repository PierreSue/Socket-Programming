import java.io.*;
import java.net.*;


class UDPClient {
//int change to bytes
	public static final byte[] intToByteArray(int value) {
	    return new byte[] {
	            (byte)(value >>> 24),
	            (byte)(value >>> 16),
	            (byte)(value >>> 8),
	            (byte)value};
	}

	public static void main (String args[]) throws Exception {
		DatagramSocket clientSocket = new DatagramSocket();

		InetAddress serverIP = InetAddress.getByName("127.0.0.1");

		for(int i=1;i<=1000;i++)
		{
			byte[] bytes = intToByteArray(i);
			DatagramPacket sendPkt = new DatagramPacket(bytes, bytes.length ,serverIP, 9090);
			clientSocket.send(sendPkt);
			//time delay
			Thread.sleep(1);
		}
	}
}