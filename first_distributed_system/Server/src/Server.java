import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public Server(){
        int count = 0;
        while(true){
            try{

                ServerSocket socket = new ServerSocket(8888);
                Socket client = socket.accept();
                System.out.println("Accepted");
                Connection c = new Connection(client, count);
                Thread t = new Thread(c);
                t.start();
                count++;
            }
            catch(Exception e)
            {

            }
        }
    }

}
