import javax.tools.*;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
            System.out.println(functions.getMethods(packageName + "." + className));
            out.println(functions.getMethods(packageName + "." + className));
            out.flush();

            String request = in.readLine();
            String[] parts = request.split("\\|\\|\\|");
            String[] numbers = null;
            if(parts.length > 1){
                 numbers = parts[1].split(",");
            }

            Class operator = Class.forName(packageName + "." + className);
            String answer = "";
            System.out.println(request);
            for (Method m : operator.getMethods()) {
                if (m.getName().toLowerCase().equals(parts[0].toLowerCase())) {
                    Object[] args = new Object[m.getParameterTypes().length];
                    if(numbers != null){
                        int i = 0;
                        for(Class classp : m.getParameterTypes()){
//                            if(m.getParameterTypes().length >= numbers.length){
//
//                            }
                            String[] param = numbers[i].split("::");
                            if(functions.getPrimitiveType(classp.getName()) != null){
                                Class c = Class.forName(param[1]);
                                Method method = c.getMethod("valueOf", String.class);
                                args[i] = method.invoke(null, param[0]);
                            }
                            else{
                                if(classp.getName().equals("java.lang.String"))
                                    args[i] = param[0];
                                else{
                                    Constructor[] constructors = classp.getConstructors();
                                    Constructor con = constructors[0];
                                    if(constructors.length > 1)
                                        con = constructors[1];
                                    args[i] = con.newInstance(getConstructorParams(con,numbers, i));
                                }
                            }
                            i++;

                        }


                    }
                    answer += m.invoke(operator.newInstance(), args);
                }
            }
            out.println(answer);
            out.flush();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(connectionNr + " Disconnected.");
            notDone = false;
        }
    }

    private Object[] getConstructorParams(Constructor con, String[] numbers, int i){
        Object[] args = new Object[con.getParameterTypes().length];
        try{
            int j = 0;
            for(Class classp : con.getParameterTypes()){
                String[] param = numbers[i].split("::");
                if(functions.getPrimitiveType(classp.getName()) !=null){
                    Class c = Class.forName(param[1]);
                    Method method = c.getMethod("valueOf", String.class);
                    args[j] = method.invoke(null, param[0]);
                }
                else{
                    args[j] = param[0];
                }
                j++;
                i++;
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return args;
    }

    private Object getObject(Constructor constructor, Object[] args){
        Object object = null;
        try {
            object = constructor.newInstance(args);
        }catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return object;
    }


}
