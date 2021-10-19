import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{
    private Socket client;
    private ObjectInputStream input_stream;
    private ObjectOutputStream output_stream;
    private static int clientCount=0;

    public Server(ServerSocket socket) throws IOException {
        client=socket.accept();
        clientCount++;
        System.out.println("client "+clientCount+" is connected");
        input_stream = new ObjectInputStream(client.getInputStream());
        output_stream = new ObjectOutputStream(client.getOutputStream());
    }

    public void Release() throws IOException, NullPointerException {
        input_stream.close();
        output_stream.close();
        client.close();
    }

    @Override
    public void run() {
        try {
            int size = (int) input_stream.readObject();
            int min = 0;
            int max = size;
            System.out.println("~client: " + size);
            int[] array = new int[size];
            for (int i = 0; i < size; i++)
                array[i] = (int) (min + (Math.random() * (max - min)));
            Thread.sleep(1500);
            output_stream.writeObject(array);
            this.Release();
        } catch (IOException | ClassNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        final int PORT = 2525;

        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while (true) {
                //Socket client = serverSocket.accept();
                /*clientCount++;
                System.out.println("client "+clientCount+" is connected");*/
                try{
                    new Server(serverSocket).start();
                }
                catch(IOException e){
                    e.printStackTrace();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}