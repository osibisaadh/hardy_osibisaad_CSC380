
package jaxb.rResponse;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jaxb.rResponse package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Name_QNAME = new QName("http://osibisaadhardy/rResponse", "Name");
    private final static QName _Id_QNAME = new QName("http://osibisaadhardy/rResponse", "Id");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jaxb.rResponse
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Body }
     * 
     */
    public Body createBody() {
        return new Body();
    }

    /**
     * Create an instance of {@link RestaurantsResponse }
     * 
     */
    public RestaurantsResponse createRestaurantsResponse() {
        return new RestaurantsResponse();
    }

    /**
     * Create an instance of {@link Restaurant }
     * 
     */
    public Restaurant createRestaurant() {
        return new Restaurant();
    }

    /**
     * Create an instance of {@link Envelope }
     * 
     */
    public Envelope createEnvelope() {
        return new Envelope();
    }
//
//    /**
//     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
//     *
//     */
//    @XmlElementDecl(namespace = "http://osibisaadhardy/rResponse", name = "Name")
//    public JAXBElement<String> createName(String value) {
//        return new JAXBElement<String>(_Name_QNAME, String.class, null, value);
//    }
//
//    /**
//     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
//     *
//     */
//    @XmlElementDecl(namespace = "http://osibisaadhardy/rResponse", name = "Id")
//    public JAXBElement<BigInteger> createId(BigInteger value) {
//        return new JAXBElement<BigInteger>(_Id_QNAME, BigInteger.class, null, value);
//    }


}
