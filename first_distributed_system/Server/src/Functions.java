import javax.tools.*;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Osibisaad
 * Date: 7/15/13
 * Time: 10:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class Functions {

    private static Functions instance;
    private String packageName;

    public static Functions getInstance(String packageName){
        if(instance == null)
            instance = new Functions(packageName);
        return instance;
    }

    private Functions(){ }

    private Functions(String packageName){
        this.packageName = packageName;
    }

    public List<Class> getClasses() throws IOException, ClassNotFoundException {
        List<Class> commands = new ArrayList<Class>();

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(
                null, null, null);

        JavaFileManager.Location location = StandardLocation.CLASS_PATH;
        Set<JavaFileObject.Kind> kinds = new HashSet<JavaFileObject.Kind>();
        kinds.add(JavaFileObject.Kind.CLASS);
        boolean recurse = false;

        Iterable<JavaFileObject> list = fileManager.list(location, packageName,
                kinds, recurse);

        for (JavaFileObject javaFileObject : list) {
            String[] file = javaFileObject.getName().split("\\\\");
            String[] fileName = file[file.length-1].split("\\.");

            commands.add(Class.forName(packageName + "." + fileName[0]));
        }

        return commands;
    }

    private String getPrimitiveType(String name)
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

    public String getMethods(String className){
        String s = "";
        try{
            Class c = Class.forName(className);
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
                    s = s.substring(0, s.length()-1);
                s += ";";

            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return s;
    }

}
