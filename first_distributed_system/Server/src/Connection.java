import java.io.*;
import java.lang.reflect.Method;
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
        boolean needPrompt = true;

        while(notDone){
            try{
                out = new PrintWriter(this.socket.getOutputStream());
                in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                if(needPrompt){
                    out.println(getMethods());
                    out.flush();
                    needPrompt = false;
                }
                String request  = in.readLine();
                System.out.println(request);
                String[] parts = request.split(" ");
                String[] numbers = parts[1].split(",");

                Class operator = Class.forName("MathLogic");
                String answer = "";
                for(Method m : operator.getMethods()){

                    if(m.getName().toLowerCase().equals(parts[0])){
                        Object[] args = new Object[numbers.length];
                        for(int i = 0; i < numbers.length; i++){
                            String[] param = numbers[i].split(":");
                            Class c = Class.forName(param[1]);
                            Method method = c.getMethod("valueOf",String.class);


                            args[i] = method.invoke(null, param[0]);
                        }
                        answer += m.invoke(operator, args);

                    }
                }

                System.out.println(answer);
                out.println(answer);
                out.flush();

            }
            catch(Exception e){
                System.out.println(connectionNr + " Disconnected.");
                notDone = false;
            }
        }
    }

    public String getPrimitiveType(String name)
    {
        if (name.equals("byte")) return "java.lang.Byte";
        if (name.equals("short")) return "java.lang.Short";
        if (name.equals("int")) return "java.lang.Integer";
        if (name.equals("long")) return "java.lang.Long";
        if (name.equals("char")) return "java.lang.Character";
        if (name.equals("float")) return "java.lang.Float";
        if (name.equals("double")) return "java.lang.Double";
        if (name.equals("boolean")) return "java.lang.Boolean";



        return null;
    }

    public String getMethods(){
        String s = "";
        try{
            Class c = Class.forName("MathLogic");
            for(Method m : c.getDeclaredMethods()){
                s += m.getName() + ":";
                boolean hasParams = false;
                for(Class param : m.getParameterTypes() ){
                    if(getPrimitiveType(param.getName()) !=null)
                        s+= getPrimitiveType(param.getName()) + ",";
                    else
                        s+= param.getName() + ",";
                    hasParams = true;
                }
                if(hasParams)
                    s = s.substring(0, s.length()-1) + ";";
            }

        }catch(Exception e){
            e.printStackTrace();
        }
     return s;
    }

}
