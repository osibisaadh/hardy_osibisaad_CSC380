import java.io.*;
import java.net.Socket;

public class Connection implements Runnable {
    private Socket socket;
    private int connectionNr;
    private PrintWriter out;
    private BufferedReader in;

    public Connection(Socket socket, int connectionNr){
        this.socket = socket;
        this.connectionNr = connectionNr;
    }

    public void run(){
        boolean notDone = true;

        int answer = 0;
        while(notDone){
            try{
                out = new PrintWriter(this.socket.getOutputStream());
                in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                String request  = in.readLine();
                String[] parts = request.split(" ");
                String[] numbers = parts[1].split(",");
                if(parts[0].equals("add")){
                    answer = MathLogic.add(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]));
                }
                else if(parts[0].equals("subtract")){
                    answer = MathLogic.subtract(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]));
                }
                out.write(answer);
                out.flush();
            }
            catch(Exception e){
                System.out.println(connectionNr + " Disconnected.");
                notDone = false;
            }
        }
    }

}
