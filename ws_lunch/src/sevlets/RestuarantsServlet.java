package sevlets;

import DB.RequestHandler;
import jaxb.rRequest.Envelope;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.*;
import java.io.*;

/** User: zacharyhunt Date: 7/24/13 */

@WebServlet ("/restaurants")
public class RestuarantsServlet extends HttpServlet
{
    RequestHandler requestHandler = RequestHandler.getInstance();

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        Envelope soapRequest = null;


        try{
            JAXBContext requestContext = JAXBContext.newInstance("jaxb.rRequest");
            Unmarshaller unmarshaller = requestContext.createUnmarshaller();
             soapRequest = (Envelope) unmarshaller.unmarshal(request.getInputStream());

        }catch(Exception e){
            e.printStackTrace();
        }

        jaxb.rResponse.Envelope envelope = requestHandler.doAction(soapRequest.getBody().getGetRestaurants());

        JAXBContext jaxbContext;
        try
        {
            jaxbContext = JAXBContext.newInstance("jaxb.rResponse");
            Marshaller marshaller = jaxbContext.createMarshaller();

            File xml = new File("restaurants.xml");

            marshaller.marshal(envelope, xml);
            ServletOutputStream stream = null;
            BufferedInputStream buf = null;
            try {
                stream = response.getOutputStream();
                response.setContentType("text/xml");

                response.setContentLength((int) xml.length());
                FileInputStream input = new FileInputStream(xml);
                buf = new BufferedInputStream(input);
                int readBytes = 0;
                while ((readBytes = buf.read()) != -1)
                    stream.write(readBytes);

                stream.flush();
            } catch (IOException ioe) {
                throw new ServletException(ioe.getMessage());
            } finally {
                if (stream != null)
                    stream.close();
                if (buf != null)
                    buf.close();
            }


        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
    }

//
//    private void doAction(GetRestaurants cmd){
//
//    }
//
//    private void doAction(GetMenu cmd){
//
//    }


}