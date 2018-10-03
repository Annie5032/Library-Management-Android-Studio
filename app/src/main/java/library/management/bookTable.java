package library.management;

public class bookTable {

    int id;
    String bookName;
    String bookCase;
    String bookShelf;
    int bookPosition;

    // constructors
    public bookTable() {

    }

    public bookTable(String bookName, String bookCase, String bookShelf, int bookPosition) {
        this.bookName = bookName;
        this.bookCase = bookCase;
        this.bookShelf = bookShelf;
        this.bookPosition = bookPosition;
    }

    public bookTable(int id, String bookName, String bookCase, String bookShelf, int bookPosition) {
        this.id = id;
        this.bookName = bookName;
        this.bookCase = bookCase;
        this.bookShelf = bookShelf;
        this.bookPosition = bookPosition;
    }

    // setters
    public void setId(int id) {
        this.id = id;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookCase(String bookCase) {
        this.bookCase = bookCase;
    }

    public void setBookShelf(String bookShelf) {
        this.bookShelf = bookShelf;
    }

    public void setBookPosition(int bookPosition) {
        this.bookPosition = bookPosition;
    }

    // getters
    public long getId() {
        return this.id;
    }

    public String getBookName() {
        return this.bookName;
    }

    public String getBookCase() {
        return this.bookCase;
    }

    public String getBookShelf() {
        return this.bookShelf;
    }

    public int getBookPosition() {
        return this.bookPosition;
    }
}
