import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) {
        try{
            System.out.println("server connecting...");
            Socket client = new Socket("127.0.0.1",2525);
            System.out.println("connection established...");

            //BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
            ObjectOutputStream output_stream=new ObjectOutputStream(client.getOutputStream());
            ObjectInputStream input_stream=new ObjectInputStream(client.getInputStream());
            System.out.print("~client: ");

            Scanner scan=new Scanner(System.in);
            int size = scan.nextInt();
            output_stream.writeObject(size);
            while(size!=0){

                int[] array=(int[])(input_stream.readObject());
                int i=0;
                System.out.println("~server: sent array\narray:");
                for(int value: array)
                    System.out.println((i++)+")\t"+value);

                System.out.print("~client: ");
                size=scan.nextInt();
                output_stream.writeObject(size);
            }
            output_stream.close();
            input_stream.close();
            client.close();
        }catch(Exception exp) {
            exp.printStackTrace();
        }
    }
}
