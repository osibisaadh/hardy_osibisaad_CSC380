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
        int count = 0;
        while(true){
            try{
                ServerSocket socket = new ServerSocket(port);
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
