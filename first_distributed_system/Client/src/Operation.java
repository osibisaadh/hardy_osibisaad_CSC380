import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Osibisaad
 * Date: 7/11/13
 * Time: 10:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class Operation {


    private String name;
    private List<Class> params;

    public Operation(String name, String[] params){
        this.name = name;
        this.params = new ArrayList<Class>();
        if(params != null){
            for(String param : params){
                try {
                    System.out.println(param);
                    this.params.add(Class.forName(param));
                }catch(Exception e){
                    e.printStackTrace();
                }
            }

        }

    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if(obj instanceof Operation){
            equal = ((Operation) obj).getName().equals(this.name);
        }
        return equal;
    }

    public List<Class> getParams() {
        return params;
    }

    public String getName() {
        return name;
    }

}
