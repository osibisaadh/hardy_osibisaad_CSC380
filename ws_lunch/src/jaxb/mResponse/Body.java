
package jaxb.mResponse;

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
 *         &lt;element ref="{http://osibisaadhardy}MenuResponse"/>
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
    "menuResponse"
})
@XmlRootElement(name = "Body", namespace = "http://www.w3.org/2001/12/soap-envelope")
public class Body {

    @XmlElement(name = "MenuResponse", namespace = "http://osibisaadhardy", required = true)
    protected MenuResponse menuResponse;

    /**
     * Gets the value of the menuResponse property.
     * 
     * @return
     *     possible object is
     *     {@link MenuResponse }
     *     
     */
    public MenuResponse getMenuResponse() {
        return menuResponse;
    }

    /**
     * Sets the value of the menuResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link MenuResponse }
     *     
     */
    public void setMenuResponse(MenuResponse value) {
        this.menuResponse = value;
    }

}
