package models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * Created with IntelliJ IDEA.
 * User: Osibisaad
 * Date: 7/24/13
 * Time: 4:09 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "item", propOrder = {
        "name",
        "price"
})
public class Item {
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "price", required = true)
    protected double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
