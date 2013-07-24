package models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * Created with IntelliJ IDEA.
 * User: Osibisaad
 * Date: 7/23/13
 * Time: 11:06 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "book", propOrder = {
        "name",
        "menu"
})
public class Restaurant {
    @XmlAttribute(name = "name", required = true)
    private String name;
    @XmlAttribute(name = "menu", required = true)
    private Menu menu;

    public Restaurant(){}

    public Restaurant(String name, Menu menu) {
        this.name = name;
        this.menu = menu;
    }

    public String getName() {
        return name;
    }

    public Menu getMenu() {
        return menu;
    }
}
