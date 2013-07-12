
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Client {

    private int port;
    private Scanner scan = new Scanner(System.in);

    public Client(int port){
        this.port = port;
    }

    public void Connect(){
        try{
            List<Operation> operationList = new ArrayList<Operation>();
            Socket socket = new Socket("localhost",port);
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String options = in.readLine();
            String[] methods = options.split(";");
            for(String method : methods){
                String[] signature = method.split(":");
                String[] params = signature[1].split(",");
                operationList.add(new Operation(signature[0].toLowerCase(), params));
            }
            System.out.println(options);
            String prompt = "Choose Operation: ";

            for(Operation o : operationList){
                prompt += o.getName() + ",";
            }
            prompt += " or Exit";

            boolean notDone = true;
            while(notDone){

                System.out.println(prompt);
                String operation = scan.nextLine();

                operation = operation.toLowerCase();
                if(operationExists(operationList, operation)){
                    System.out.println("You chose " + operation + ", now insert its parameters");
                    Operation oper = getOperation(operationList, operation);
                    String request = operation + " ";
                    List<Class> params = oper.getParams();
                    for(int i = 0; i < params.size(); i++){
                        request +=  getInput(params.get(i).getName());
                        if(i < params.size()-1)
                            request += ",";
                    }
                    out.println(request);
                    out.flush();
                    System.out.println("Answer: " + in.readLine());
                }
                else if(operation.equals("exit")){
                    notDone = false;
                    out.close();
                    in.close();
                    socket.close();
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }


    }

    public Operation getOperation(List<Operation> operationList, String operation){
        for(Operation o : operationList)
            if(o.getName().equals(operation))
                return o;
        return null;
    }

    public boolean operationExists(List<Operation> operationList, String operation){
        boolean found = false;

        for(int i = 0; i < operationList.size() && !found; i++){
            found = operationList.get(i).getName().equals(operation);
        }

        return found;
    }

    public String getInput(String type){
        boolean invalid = true;
        String input = "";
        while(invalid){
            System.out.println("Input a " + type + ".");
            try{
                Class c = Class.forName(type);
                Method m = c.getMethod("valueOf",String.class);

                input += m.invoke(null,scan.next()) + ":" + type;
                System.out.println(input.split(":")[0]);
                invalid = false;

            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        return input;
    }
}
