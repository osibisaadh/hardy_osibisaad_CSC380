package models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Osibisaad
 * Date: 7/23/13
 * Time: 11:48 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "menu")
public class Menu {
    private List<Item> items;

    public Menu() {}
    public Menu(List<Item> items) {

        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

}
