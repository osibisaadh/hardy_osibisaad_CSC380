
package jaxb.rResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://osibisaadhardy/rResponse}RestaurantsResponse"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "restaurantsResponse"
})
@XmlRootElement(name = "Body", namespace = "http://www.w3.org/2001/12/soap-envelope")
public class Body {

    @XmlElement(name = "RestaurantsResponse", namespace = "http://localhost:8080/restaurants", required = true)
    protected RestaurantsResponse restaurantsResponse;

    /**
     * Gets the value of the restaurantsResponse property.
     * 
     * @return
     *     possible object is
     *     {@link RestaurantsResponse }
     *     
     */
    public RestaurantsResponse getRestaurantsResponse() {
        return restaurantsResponse;
    }

    /**
     * Sets the value of the restaurantsResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link RestaurantsResponse }
     *     
     */
    public void setRestaurantsResponse(RestaurantsResponse value) {
        this.restaurantsResponse = value;
    }

}
