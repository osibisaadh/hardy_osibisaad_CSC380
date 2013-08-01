
package jaxb.mRequest;

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
 *         &lt;element ref="{http://osibisaadhardy}GetMenu"/>
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
    "getMenu"
})
@XmlRootElement(name = "Body", namespace = "http://www.w3.org/2001/12/soap-envelope")
public class Body {

    @XmlElement(name = "GetMenu", namespace = "http://osibisaadhardy", required = true)
    protected GetMenu getMenu;

    /**
     * Gets the value of the getMenu property.
     * 
     * @return
     *     possible object is
     *     {@link GetMenu }
     *     
     */
    public GetMenu getGetMenu() {
        return getMenu;
    }

    /**
     * Sets the value of the getMenu property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetMenu }
     *     
     */
    public void setGetMenu(GetMenu value) {
        this.getMenu = value;
    }

}
