
package jaxb.oRequest;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jaxb.oRequest package. 
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

    private final static QName _RestaurantId_QNAME = new QName("http://osibisaadhardy", "RestaurantId");
    private final static QName _ItemId_QNAME = new QName("http://osibisaadhardy", "ItemId");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jaxb.oRequest
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
     * Create an instance of {@link CreateOrder }
     * 
     */
    public CreateOrder createCreateOrder() {
        return new CreateOrder();
    }

    /**
     * Create an instance of {@link Envelope }
     * 
     */
    public Envelope createEnvelope() {
        return new Envelope();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://osibisaadhardy", name = "RestaurantId")
    public JAXBElement<BigInteger> createRestaurantId(BigInteger value) {
        return new JAXBElement<BigInteger>(_RestaurantId_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://osibisaadhardy", name = "ItemId")
    public JAXBElement<BigInteger> createItemId(BigInteger value) {
        return new JAXBElement<BigInteger>(_ItemId_QNAME, BigInteger.class, null, value);
    }

}
