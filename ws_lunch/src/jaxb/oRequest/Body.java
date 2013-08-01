
package jaxb.oRequest;

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
 *         &lt;element ref="{http://osibisaadhardy}CreateOrder"/>
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
    "createOrder"
})
@XmlRootElement(name = "Body", namespace = "http://www.w3.org/2001/12/soap-envelope")
public class Body {

    @XmlElement(name = "CreateOrder", namespace = "http://osibisaadhardy", required = true)
    protected CreateOrder createOrder;

    /**
     * Gets the value of the createOrder property.
     * 
     * @return
     *     possible object is
     *     {@link CreateOrder }
     *     
     */
    public CreateOrder getCreateOrder() {
        return createOrder;
    }

    /**
     * Sets the value of the createOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreateOrder }
     *     
     */
    public void setCreateOrder(CreateOrder value) {
        this.createOrder = value;
    }

}
