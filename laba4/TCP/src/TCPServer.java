import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket client = null;
        ObjectInputStream input_stream = null;
        ObjectOutputStream output_stream=null;
        try{
            System.out.println("server starting...");
            serverSocket = new ServerSocket(2525);
            client=serverSocket.accept();
            System.out.println("connection established...");
            input_stream=new ObjectInputStream(client.getInputStream());
            output_stream=new ObjectOutputStream(client.getOutputStream());
            int size = (int)input_stream.readObject();
            int min=0;
            while(size!=0){
                int max=size;
                System.out.println("~client: "+size);
                int[] array=new int[size];
                for(int i=0;i<size;i++)
                    array[i]=(int)(min+(Math.random()*(max-min)));
                output_stream.writeObject(array);
                size=(int)input_stream.readObject();
            }
        }catch(Exception exp) {
            exp.printStackTrace();
        } finally {
            try{
                if(input_stream!=null)
                    input_stream.close();
                if(output_stream!=null)
                    output_stream.close();
                if(client!=null)
                    client.close();
                if(serverSocket!=null)
                    serverSocket.close();
            }catch(Exception exp){
                exp.printStackTrace();
            }
        }
    }
}
