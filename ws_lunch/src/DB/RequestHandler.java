package DB;

import Model.*;
import jaxb.mRequest.GetMenu;
import jaxb.mResponse.Envelope;
import jaxb.mResponse.MenuResponse;
import jaxb.oRequest.CreateOrder;
import jaxb.rRequest.GetRestaurants;
import jaxb.rResponse.Body;
import jaxb.rResponse.RestaurantsResponse;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ohardy
 * Date: 7/30/13
 * Time: 7:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class RequestHandler {

    private static RequestHandler requestHandler;
    private List<Model.Order> orders = new ArrayList<Model.Order>();
    private DataHolder db = DataHolder.getInstance();

    private RequestHandler(){}

    public static RequestHandler getInstance(){
        if(requestHandler == null){
            requestHandler = new RequestHandler();
        }
        return requestHandler;
    }

    public jaxb.rResponse.Envelope doAction(GetRestaurants get){
        List<Restaurant> dbRestaurants = db.getRestaurants ();
        List<jaxb.rResponse.Restaurant> restaurants = new ArrayList<jaxb.rResponse.Restaurant>();
        for(Restaurant r : dbRestaurants){
            jaxb.rResponse.Restaurant restaurant = new jaxb.rResponse.Restaurant();
            restaurant.setName(r.getName());
            restaurant.setId(r.getId());

            restaurants.add(restaurant);
        }
        jaxb.rResponse.Envelope envelope = new jaxb.rResponse.Envelope();
        RestaurantsResponse restaurantsResponse = new RestaurantsResponse();
        restaurantsResponse.setRestaurant(restaurants);
        jaxb.rResponse.Body responseBody = new Body();
        responseBody.setRestaurantsResponse(restaurantsResponse);

        envelope.setBody(responseBody);
        return envelope;
    }

    public jaxb.mResponse.Envelope doAction(GetMenu get){
        Menu tempMenu = db.getRestaurant(get.getId().intValue()).getMenu();
        MenuResponse menu = new MenuResponse();

        for(Item i : tempMenu.getItems()){
            jaxb.mResponse.Item item = new jaxb.mResponse.Item();
            item.setId(i.getId());
            item.setName(i.getName());
            item.setPrice(BigDecimal.valueOf(i.getPrice()));
            menu.getItem().add(item);
        }
        jaxb.mResponse.Body body = new jaxb.mResponse.Body();
        body.setMenuResponse(menu);
        jaxb.mResponse.Envelope envelope = new Envelope();
        envelope.setBody(body);

        return envelope;
    }

    public boolean doAction(CreateOrder createOrder){
        Model.Order order = new Order();
        Model.Item fakeItem = db.getItem(createOrder.getRestaurantId().intValue(), createOrder.getItemId().intValue());
        Model.Restaurant fakeRestaurant = db.getRestaurant(createOrder.getRestaurantId().intValue());
        OrderItem orderItem = new OrderItem();
        orderItem.setName(fakeItem.getName());
        orderItem.setPrice(fakeItem.getPrice());

        OrderRestaurant orderRestaurant = new OrderRestaurant();
        orderRestaurant.setName(fakeRestaurant.getName());

        order.setOrderItem(orderItem);
        order.setOrderRestaurant(orderRestaurant);

        orders.add(order);

        return true;
    }

    public List<Order> getOrders(){
        return orders;
    }

}
