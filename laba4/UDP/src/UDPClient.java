import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Scanner;

public class UDPClient {
    private final int SIZE = 512;
    private final String CALC_STR = "CALCULATE";
    private final String QUIT_STR = "QUIT";

    private static void inputValues(byte[] buffer) {
        Scanner scan = new Scanner(System.in);
        System.out.print("UDPClient: input x = ");
        buffer[0] = scan.nextByte();
        System.out.print("UDPClient: input y = ");
        buffer[1] = scan.nextByte();
    }

    public static void main(String[] args) {
        try{
            UDPClient client = new UDPClient();
            client.runClient();
        }catch (IOException exp){
            exp.printStackTrace();
        }
    }

    private static void sendInformation(DatagramSocket socket, DatagramPacket packet, byte[] buf) {
        try {
            packet.setData(buf);
            packet.setLength(buf.length);
            socket.send(packet);
        } catch (Exception ex) {
            System.out.println("packet wasn't send");
        }
    }

    public void runClient() throws IOException {
        DatagramSocket socket = null;
        byte[] buffer = new byte[SIZE];
        try {
            socket = new DatagramSocket();
            System.out.println("UDPClient: Started");

            DatagramPacket sendPacket = new DatagramPacket(
                    buffer,
                    buffer.length,
                    InetAddress.getByName("127.0.0.1"),
                    8001);

            sendInformation(socket, sendPacket, CALC_STR.getBytes());

            inputValues(buffer);
            sendInformation(socket, sendPacket, buffer);

            Arrays.fill(buffer, (byte) '\0');

            DatagramPacket recvPacket = new DatagramPacket(buffer, buffer.length);
            socket.receive(recvPacket);
            String answer = new String(buffer).trim();
            System.out.println("UDPClient: Server answer: " + answer);

            sendInformation(socket, sendPacket, QUIT_STR.getBytes());

            System.out.println("UDPClient: Ended");
        } finally {
            if (socket != null)
                socket.close();
        }
    }
}