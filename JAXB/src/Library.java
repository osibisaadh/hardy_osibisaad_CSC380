import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ohardy
 * Date: 7/22/13
 * Time: 6:33 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement
public class Library {

    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Library() {

    }

}
