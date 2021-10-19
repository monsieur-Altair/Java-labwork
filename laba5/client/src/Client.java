

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ref.Cleaner;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket client;
    private ObjectOutputStream output_stream;
    private ObjectInputStream input_stream;
    private Scanner scan;

    public Client(String host, int port) throws IOException{
        client = new Socket("127.0.0.1",2525);
        output_stream=new ObjectOutputStream(client.getOutputStream());
        input_stream=new ObjectInputStream(client.getInputStream());
        scan=new Scanner(System.in);
        System.out.println("connection established...");
        Object obj;

    }

    public void Run() throws IOException,ClassNotFoundException{
        System.out.print("~client: ");

        int size = scan.nextInt();
        output_stream.writeObject(size);

        int[] array=(int[])(input_stream.readObject());
        System.out.print("~server: sent array-> ");
        for(int value: array)
            System.out.print("\t"+value);
        System.out.println();
    }

    public void Close() throws IOException{
        output_stream.close();
        input_stream.close();
        client.close();
    }


    public static void main(String[] args) {
        final String HOST="127.0.0.1";
        final int PORT=2525;
        try{
            Client client=new Client(HOST,PORT);
            client.Run();
            client.Close();
        }catch(Exception exp) {
            exp.printStackTrace();
        }
    }
}
