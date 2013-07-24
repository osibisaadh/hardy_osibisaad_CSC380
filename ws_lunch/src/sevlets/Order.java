package sevlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Osibisaad
 * Date: 7/23/13
 * Time: 9:05 PM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "Restaurant/*/*")
public class Order extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] route = request.getPathInfo().split("/");
        String resource = route[route.length-1];

    }
}
