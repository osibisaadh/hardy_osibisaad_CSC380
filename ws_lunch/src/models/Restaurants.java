package models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

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
    @XmlElement(nillable = false, name = "restaurant", required = true)
    protected List<Restaurant> restaurants;

//    public Restaurants(List<Restaurant> restaurants) {
//        this.restaurants = restaurants;
//    }

//    private void init(){
//
//        ArrayList<Item> menu = new ArrayList<Item>();
//        menu.add(new Item("foigrass",2.33));
//        menu.add(new Item("Dog food", 1.00));
//        menu.add(new Item("Kiwi", 0.75));
//        restaurants.add(new Restaurant("Lao's Dinner",new Menu(menu)));
//        menu = new ArrayList<Item>();
//        menu.add(new Item("Sandwich", 1.30));
//        menu.add(new Item("Top Ramen", 0.66));
//        menu.add(new Item("Bread", 1.50));
//        restaurants.add(new Restaurant("Lao's Dinner",new Menu(menu)));
//    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
