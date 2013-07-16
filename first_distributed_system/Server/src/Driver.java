import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class Driver {

    private final static String packageName = "libs";
    private final static int port = 8889;

    public static void main(String[] args){
        Server server = new Server(packageName, port);
        server.run();
    }
}
