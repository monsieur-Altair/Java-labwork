
import java.io.FileWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

import static java.lang.Math.*;

public class UDPServer {
    private final static int DEFAULT_PORT = 8001;
    private final static int SIZE = 512;
    private final String CALCULATE_CMD = "CALCULATE";
    private final String QUIT_CMD = "QUIT";
    private final String UNKNOWN_COMMAND = "Unknown command";

    public static void main(String[] args) {
        try {
            UDPServer server = new UDPServer();
            server.runServer();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    private static double function(double x, double y){
        return 5*atan(x)-0.25*cos((x+3*abs(x-y)+x*x)/(pow(abs(x+y*y),3)+pow(x,3)));
    }

    private static void writeToFile(byte x, byte y, double res){
        try{
            FileWriter writer = new FileWriter("server_log.txt",true);
            writer.write("x = "+x+"\ty = "+y+"\tresult = "+res+"\n");
            writer.flush();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }

    public void runServer() throws IOException{
        DatagramSocket socket=null;
        boolean isStop=false;
        byte[] buffer=new byte[SIZE];

        try{

            socket = new DatagramSocket(DEFAULT_PORT);
            System.out.println("UDPServer: Started on "+socket.getLocalAddress()+":"+socket.getLocalPort());
            DatagramPacket recvPacket=new DatagramPacket(buffer,buffer.length);

            while(!isStop){
                socket.receive(recvPacket);
                String cmd = new String(recvPacket.getData()).trim();
                System.out.println("UDPServer: Command "+cmd);

                DatagramPacket sendPacket = new DatagramPacket(buffer,0,recvPacket.getAddress(),recvPacket.getPort());

                if(cmd.equals(CALCULATE_CMD)){
                    socket.receive(recvPacket);
                    byte x=buffer[0];
                    byte y=buffer[1];

                    System.out.println("UDPServer: x = "+x+" y = "+y);
                    double result=function(x,y);
                    System.out.println("UDPServer: result = "+result);
                    writeToFile(x,y,result);
                    String res=String.valueOf(result);
                    buffer = res.getBytes();

                }else if(cmd.equals(QUIT_CMD)){
                    isStop=true;
                    continue;
                }else{
                    buffer=UNKNOWN_COMMAND.getBytes();
                }

                sendPacket.setData(buffer);
                sendPacket.setLength(buffer.length);
                socket.send(sendPacket);
                Arrays.fill(buffer, (byte) '\0');

            }
            System.out.println("UDPServer: Stopped");
        } finally {
            if(socket!=null){
                socket.close();
            }
        }
    }
}
