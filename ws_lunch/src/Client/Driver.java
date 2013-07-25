package Client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created with IntelliJ IDEA.
 * User: Osibisaad
 * Date: 7/24/13
 * Time: 7:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class Driver {
    public static void main(String[] args){
        try{
            URL Index = new URL("http://localhost:8080/Index");
            URLConnection indexConnect = Index.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(indexConnect.getInputStream()));

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
