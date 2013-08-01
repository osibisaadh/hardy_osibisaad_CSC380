/**
 * Created with IntelliJ IDEA.
 * User: ohardy
 * Date: 7/22/13
 * Time: 6:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class Book {
    String title;
    String publisher;
    Author author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Book() {
    }
}
