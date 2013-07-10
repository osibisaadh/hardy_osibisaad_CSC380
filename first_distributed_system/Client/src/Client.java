import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: ohardy
 * Date: 7/9/13
 * Time: 5:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class Client {

    private int port;
    private Scanner scan = new Scanner(System.in);

    public Client(int port){
        this.port = port;
    }

    public void Connect(){
        try{
            Socket socket = new Socket("localhost",port);
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            InputStreamReader in = new InputStreamReader(socket.getInputStream());
            boolean notDone = true;
            while(notDone){
                System.out.println("Choose Operation: Add, Subtract, or Exit");
                String operation = scan.nextLine();
                operation = operation.toLowerCase();
                if(operation.equals("add") || operation.equals("subtract")){
                    System.out.println("You chose " + operation + ", now choose your numbers");
                    out.println(operation + " " + getInput() + "," + getInput());
                    out.flush();
                    System.out.println(in.read());
                }
                else if(operation.equals("exit")){
                    notDone = false;
                    out.close();
                    in.close();
                    socket.close();
                }
            }

        }catch(Exception e){

        }
    }

    public int getInput(){
        boolean invalid = true;
        int number = 0;
        while(invalid){
            System.out.println("Input a integer.");
            try{
                number = scan.nextInt();
                invalid = false;
            }
            catch(Exception e){

            }
        }
        return number;
    }
}
