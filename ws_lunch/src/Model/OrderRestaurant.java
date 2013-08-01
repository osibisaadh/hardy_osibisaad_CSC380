package Model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * Created with IntelliJ IDEA.
 * User: ohardy
 * Date: 7/26/13
 * Time: 2:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class OrderRestaurant {

    //@XmlAttribute(name = "name", required = true)
    protected String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
