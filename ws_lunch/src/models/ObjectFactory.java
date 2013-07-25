package models;

import javax.xml.bind.annotation.XmlRegistry;

/**
 * Created with IntelliJ IDEA.
 * User: Osibisaad
 * Date: 7/24/13
 * Time: 4:37 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRegistry
public class ObjectFactory {


    public Item createItem(){
        return new Item();
    }

    public Menu createMenu(){
        return new Menu();
    }

    public Restaurant createRestaurant(){
        return new Restaurant();
    }

    public Restaurants createRestaurants(){
        return new Restaurants();
    }
}
