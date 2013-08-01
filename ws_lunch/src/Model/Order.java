
package Model;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for order complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="order">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="orderRestaurant" type="{}orderRestaurant"/>
 *         &lt;element name="orderItem" type="{}orderItem" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class Order {

//    @XmlElement(required = true)
    protected OrderRestaurant orderRestaurant;
  //  @XmlElement(required = true)
    protected OrderItem orderItem;

    /**
     * Gets the value of the orderRestaurant property.
     * 
     * @return
     *     possible object is
     *     {@link Restaurant }
     *     
     */
    public OrderRestaurant getOrderRestaurant() {
        return orderRestaurant;
    }

    /**
     * Sets the value of the orderRestaurant property.
     * 
     * @param value
     *     allowed object is
     *     {@link Restaurant }
     *     
     */
    public void setOrderRestaurant(OrderRestaurant value) {
        this.orderRestaurant = value;
    }

    /**
     * Gets the value of the orderItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orderItem property.
     * 
     * <p>
     * For example, to add a new orderItem, do as follows:
     * <pre>
     *    getOrderItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Item }
     * 
     * 
     */
    public OrderItem getOrderItem() {
        return this.orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

}
