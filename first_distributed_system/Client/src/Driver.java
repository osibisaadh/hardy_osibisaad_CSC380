/**
 * Created with IntelliJ IDEA.
 * User: ohardy
 * Date: 7/9/13
 * Time: 6:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class Driver {
    public static void main(String[] args){
        Client client = new Client(8889);
        client.Connect();
    }
}
