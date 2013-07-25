package models;

import javax.xml.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: Osibisaad
 * Date: 7/23/13
 * Time: 11:06 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "restaurant", propOrder = {
        "name",
        "menu"
})
public class Restaurant {
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlElement(name = "menu", required = true)
    protected Menu menu;

    public String getName() {
        return name;
    }

    public Menu getMenu() {
        return menu;
    }
}
