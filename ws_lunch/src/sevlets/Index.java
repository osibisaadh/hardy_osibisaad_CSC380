package sevlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: Osibisaad
 * Date: 7/24/13
 * Time: 1:27 PM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "Index")
public class Index extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setHeader("content type", "");
        PrintWriter out = response.getWriter();

    }
}
