package sevlets;

import DB.RequestHandler;
import jaxb.mRequest.Envelope;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Osibisaad
 * Date: 7/23/13
 * Time: 9:06 PM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet("/menu")
public class Menu extends HttpServlet {
    RequestHandler requestHandler = RequestHandler.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Envelope soapRequest = null;

        try{
            JAXBContext requestContext = JAXBContext.newInstance("jaxb.mRequest");
            Unmarshaller unmarshaller = requestContext.createUnmarshaller();
            soapRequest = (Envelope) unmarshaller.unmarshal(request.getInputStream());

        }catch(Exception e){
            e.printStackTrace();
        }

        jaxb.mResponse.Envelope envelope = requestHandler.doAction(soapRequest.getBody().getGetMenu());

        JAXBContext jaxbContext;
        try
        {
            jaxbContext = JAXBContext.newInstance("jaxb.mResponse");
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
}
