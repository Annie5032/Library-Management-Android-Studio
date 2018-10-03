package library.management;

public class publisherTable {

    int id;
    String name;
    double bookWidth;

    // constructors
    public publisherTable() {

    }

    public publisherTable(String name, double bookWidth) {
        this.name = name;
        this.bookWidth = bookWidth;
    }

    public publisherTable(int id, String name, double bookWidth) {
        this.id = id;
        this.name = name;
        this.bookWidth = bookWidth;
    }

    // setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBookWidth(double bookWidth) {
        this.bookWidth = bookWidth;
    }

    // getters
    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getBookWidth() {
        return this.bookWidth;
    }
}