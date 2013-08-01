
package Model;

import java.util.ArrayList;
import java.util.List;

public class Restaurants {

    protected List<Restaurant> restaurants;

    public List<Restaurant> getRestaurants() {
        if (this.restaurants == null) {
            this.restaurants = new ArrayList<Restaurant>();
        }
        return this.restaurants;
    }


}
