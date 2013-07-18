package libs;

import util.Person;

/**
 * Created with IntelliJ IDEA.
 * User: Osibisaad
 * Date: 7/13/13
 * Time: 10:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class Messages {
    public String Hobo(){
        return "Homeless yo";
    }

    public String Echo(String echo){
        return echo;
    }

    public String newFile(Person person){


        return "Person " + person.getName() + " age: " + person.getAge();
    }
}