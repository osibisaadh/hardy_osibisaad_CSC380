package Client;

import Model.Item;
import Model.Menu;
import Model.Order;
import Model.Restaurant;
import Model.Restaurants;
import Model.OrderItem;
import Model.OrderRestaurant;
import sun.net.www.protocol.http.HttpURLConnection;

import javax.xml.bind.*;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Osibisaad
 * Date: 7/24/13
 * Time: 7:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class Driver {

    private static Unmarshaller unmarshaller;
    private static Scanner scanner = new Scanner(System.in);

    public static boolean menu(){
        boolean choice = false;
        boolean valid = false;
        while(!valid){
            System.out.println("Would you like to order? y/n");
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("y")){
                choice = true;
                valid = true;
            }else if(input.equalsIgnoreCase("n")){
                choice = false;
                valid = true;
            }
        }
     return choice;
    }

    public static void main(String[] args){

        boolean run = true;
        while(run){

            boolean choice = menu();
            if(choice){

                try{

                    URL Index = new URL("http://localhost:8080/restaurants");
                    HttpURLConnection indexConnect = (HttpURLConnection)Index.openConnection();
                    indexConnect.setRequestMethod("GET");
                    indexConnect.setRequestProperty("Accept", "text/xml");
                    InputStream in =indexConnect.getInputStream();

                    JAXBContext jaxbContext = JAXBContext.newInstance("gen");
                    unmarshaller = jaxbContext.createUnmarshaller();

                    Restaurant restaurant = getRestaurant(in);

                    URL menu = new URL("http://localhost:8080/menu/" + restaurant.getName());
                    URLConnection menuConnection = menu.openConnection();

                    in =menuConnection.getInputStream();

                    Item item = getItem(in);

                    URL orderURL = new URL("http://localhost:8080/order");
                    HttpURLConnection orderConnection = (HttpURLConnection)orderURL.openConnection();
                    orderConnection.setDoOutput(true);
                    orderConnection.setRequestMethod("PUT");

                    OrderItem orderItem = new OrderItem();
                    orderItem.setName(item.getName());
                    orderItem.setPrice(item.getPrice());

                    OrderRestaurant orderRestaurant = new OrderRestaurant();
                    orderRestaurant.setName(restaurant.getName());

                    Order order = new Order();
                    order.setOrderItem(orderItem);
                    order.setOrderRestaurant(orderRestaurant);

                    JAXBContext orderjaxbContext = JAXBContext.newInstance("gen.order");
                    Marshaller marshaller = orderjaxbContext.createMarshaller();
                    File xml = new File("order.xml");
                    marshaller.marshal(order, xml);

                    OutputStream stream = null;
                    BufferedInputStream buf = null;
                    try {

                        orderConnection.setDoInput(true);
                        orderConnection.setDoOutput(true);
                        orderConnection.setRequestMethod("PUT");
                        orderConnection.setRequestProperty("Content-Type", "text/xml");

                        orderConnection.setRequestProperty("Content-Length", "" + xml.length());
                        stream = orderConnection.getOutputStream();
                        FileInputStream input = new FileInputStream(xml);
                        buf = new BufferedInputStream(input);
                        int readBytes = 0;
                        while ((readBytes = buf.read()) != -1)
                            stream.write(readBytes);
                        stream.flush();
                    } catch (Exception ioe) {
                        ioe.printStackTrace();
                    } finally {
                        if (stream != null)
                            stream.close();
                        if (buf != null)
                            buf.close();
                    }
                    orderConnection.connect();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(orderConnection.getInputStream()));
                    System.out.println(reader.readLine());
                }catch(Exception e){
                    e.printStackTrace();
                }

            }
            else{
                run = false;
            }

        }
    }

    public static Item getItem(InputStream in) throws JAXBException {
        Item choice = null;
        Menu menu = (Menu) unmarshaller.unmarshal(in);
        List<Item> itemList = menu.getItems();
        boolean valid = false;
        while(!valid){
            System.out.println("Choose Item: ");
            for(int i = 0; i < itemList.size();i++){
                System.out.println(i + ": " + itemList.get(i).getName());
            }
            try{
                String index = scanner.nextLine();
                choice = itemList.get(Integer.parseInt(index));
                valid = true;

            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return choice;

    }

    public static Restaurant getRestaurant(InputStream in) throws JAXBException {
        Restaurant choice = null;
        Restaurants restaurants= (Restaurants) unmarshaller.unmarshal(in);
        List<Restaurant> restaurantList =  restaurants.getRestaurants();
        System.out.println(restaurantList.size());
        boolean valid = false;
        while(!valid){
            System.out.println("Choose Restaurant: ");
            for(int i = 0; i < restaurantList.size();i++){
                System.out.println(i + ": " + restaurantList.get(i).getName());
            }
            try{
                String index = scanner.nextLine();
                choice = restaurantList.get(Integer.parseInt(index));
                valid = true;

            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return choice;

    }

}
