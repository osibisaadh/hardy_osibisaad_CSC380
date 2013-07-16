import javax.tools.*;
import java.io.*;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Connection implements Runnable {

    private static String packageName = "libs";
    private Socket socket;
    private int connectionNr;
    private PrintWriter out;
    private BufferedReader in;
    private Functions functions;

    public Connection(Socket socket, Functions functions,int connectionNr){
        this.socket = socket;
        this.connectionNr = connectionNr;
        this.functions = functions;
    }

    public void run(){
        boolean notDone = true;

        while(notDone) try {
            out = new PrintWriter(this.socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));

            String classPrompt = "";
            List<Class> classes = functions.getClasses();
            for (Class classOption : classes) {
                classPrompt += classOption.getName().split("\\.")[1] + " ";
            }
            classPrompt = classPrompt.substring(0, classPrompt.length() - 1);
            System.out.println(classPrompt);
            out.println(classPrompt);
            out.flush();

            String className = in.readLine();

            out.println(functions.getMethods(packageName + "." + className));
            out.flush();

            String request = in.readLine();
            System.out.println(request);
            String[] parts = request.split(" ");
            String[] numbers = null;
            if(parts.length > 1){
                 numbers = parts[1].split(",");
            }

            Class operator = Class.forName(packageName + "." + className);
            String answer = "";
            for (Method m : operator.getMethods()) {

                if (m.getName().toLowerCase().equals(parts[0])) {
                    Object[] args = null;
                    if(numbers != null){
                        args = new Object[numbers.length];
                        for (int i = 0; i < numbers.length; i++) {
                            String[] param = numbers[i].split(":");
                            Class c = Class.forName(param[1]);
                            Method method = c.getMethod("valueOf", String.class);

                            args[i] = method.invoke(null, param[0]);
                        }

                    }
                    answer += m.invoke(operator.newInstance(), args);


                }
            }

            System.out.println(answer);
            out.println(answer);
            out.flush();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(connectionNr + " Disconnected.");
            notDone = false;
        }
    }




}
