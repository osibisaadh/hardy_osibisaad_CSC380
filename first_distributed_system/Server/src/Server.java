import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private Functions functions;
    private int port;

    public Server(String packageName, int port){
        functions = Functions.getInstance(packageName);
        this.port = port;
    }

    public void run(){
        ServerSocket socket = null;
        try {
            socket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        int count = 0;
        while(true){
            try{
                System.out.println("Server Started");
                Socket client = socket.accept();
                System.out.println("Accepted");
                Connection c = new Connection(client, functions,count);
                Thread t = new Thread(c);
                t.start();
                count++;
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }

}
