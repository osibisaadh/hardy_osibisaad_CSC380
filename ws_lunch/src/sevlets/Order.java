package sevlets;

import DB.RequestHandler;
import jaxb.oRequest.Envelope;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Osibisaad
 * Date: 7/23/13
 * Time: 9:05 PM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet("/order")
public class Order extends HttpServlet {

    RequestHandler requestHandler = RequestHandler.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            JAXBContext jaxbContext = JAXBContext.newInstance("jaxb.oRequest");
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            Envelope envelope = (Envelope) unmarshaller.unmarshal(req.getInputStream());

            requestHandler.doAction(envelope.getBody().getCreateOrder());

            System.out.println("Current orders: ");
            for(Model.Order o : requestHandler.getOrders()){
                System.out.println("\t" + o.getOrderItem().getName() + " : " + o.getOrderRestaurant().getName());
            }
            System.out.println();
            resp.getWriter().println("Your order has been received.");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
