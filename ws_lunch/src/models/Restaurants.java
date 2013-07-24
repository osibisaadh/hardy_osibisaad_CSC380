package models;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Osibisaad
 * Date: 7/24/13
 * Time: 1:52 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement
public class Restaurants {

    public List<Restaurant> restaurants;

    public Restaurants(){}

    public Restaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    private void init(){

        ArrayList<String> menu = new ArrayList<String>();
        menu.add("foigrass");
        menu.add("Dog food");
        menu.add("Kiwi");
        restaurants.add(new Restaurant("Lao's Dinner",new Menu(menu)));
        menu = new ArrayList<String>();
        menu.add("Sandwich");
        menu.add("Top Ramen");
        menu.add("Bread");
        restaurants.add(new Restaurant("Lao's Dinner",new Menu(menu)));
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
