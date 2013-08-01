package DB;

import Model.Item;
import Model.Menu;
import Model.Restaurant;
import Model.Restaurants;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/** User: zacharyhunt Date: 7/25/13 */
public class DataHolder
{
    private static DataHolder dataHolder = null;
    private static Restaurants restuarantManager = null;

    public static DataHolder getInstance()
    {
        if (dataHolder == null)
        {
            dataHolder = new DataHolder();
            restuarantManager = new Restaurants();
            instantiateRestaurants();
        }

        return dataHolder;
    }

    public Item getItem(int restaurantId, int id){
        Restaurant restaurant = getRestaurant(restaurantId);
        Item item = null;

        for(Item i : restaurant.getMenu().getItems()){
            if(i.getId().intValue() == id)
                item = i;
        }
        return item;
    }

    public Restaurant getRestaurant(int id)
    {
        Restaurant restaurant = null;
        for (Restaurant r : this.restuarantManager.getRestaurants())
        {
            if (r.getId() == BigInteger.valueOf(id));
            {
                restaurant = new Restaurant();
                restaurant.setName(r.getName());
                restaurant.setMenu(r.getMenu());
            }
        }
        return restaurant;
    }

    public List<Restaurant> getRestaurants(){
        return restuarantManager.getRestaurants();
    }

    public Restaurants getRestaurantWithoutMenus()
    {
        Restaurants restaurants = new Restaurants();

        List<Restaurant> tempRestaurants = this.restuarantManager.getRestaurants();
        for (Restaurant r : tempRestaurants)
        {
            Restaurant restaurant = new Restaurant();
            restaurant.setName(r.getName());
            restaurants.getRestaurants().add(restaurant);
        }
        return restaurants;
    }

    private static void instantiateRestaurants()
    {
        Menu lukesMenu = new Menu();
        Item i1 = new Item();
        i1.setId(BigInteger.valueOf(1));
        i1.setName("BaconHamburger");
        i1.setPrice(11.00);

        Item i2 = new Item();
        i2.setId(BigInteger.valueOf(2));
        i2.setName("CinnamonFrenchToast");
        i2.setPrice(6.00);

        Item i3 = new Item();
        i3.setId(BigInteger.valueOf(3));
        i3.setName("Dog");
        i3.setPrice(3.00);

        List<Item> lukesMenuItems = new ArrayList<Item>();
        lukesMenuItems.add(i1);
        lukesMenuItems.add(i2);
        lukesMenuItems.add(i3);

        lukesMenu.setItems(lukesMenuItems);

        Restaurant lukes = new Restaurant();
        lukes.setId(BigInteger.valueOf(1));
        lukes.setName("LukeDiner");
        lukes.setMenu(lukesMenu);
        restuarantManager.getRestaurants().add(lukes);

        Menu tinasMenu = new Menu();
        Item i4 = new Item();
        i4.setId(BigInteger.valueOf(1));
        i4.setName("Scone");
        i4.setPrice(11.00);

        Item i5 = new Item();
        i5.setId(BigInteger.valueOf(2));
        i5.setName("DriedFruit");
        i5.setPrice(6.00);

        Item i6 = new Item();
        i6.setId(BigInteger.valueOf(3));
        i6.setName("Possum");
        i6.setPrice(3.00);

        List<Item> tinasMenuItems = new ArrayList<Item>();
        tinasMenuItems.add(i4);
        tinasMenuItems.add(i5);
        tinasMenuItems.add(i6);

        tinasMenu.setItems(tinasMenuItems);

        Restaurant tinas = new Restaurant();
        tinas.setId(BigInteger.valueOf(2));
        tinas.setName("TinaKitchen");
        tinas.setMenu(tinasMenu);

        restuarantManager.getRestaurants().add(tinas);
    }

    private DataHolder() {}
}
