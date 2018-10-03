package library.management;

import java.sql.Blob;

public class locationTable {

    int id;
    Blob locationImage;

    // constructors
    public locationTable() {

    }

    public locationTable(Blob locationImage) {
        this.locationImage = locationImage;
    }

    public locationTable(int id, Blob locationImage) {
        this.id = id;
        this.locationImage = locationImage;
    }

    // setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(Blob locationImage) {
        this.locationImage = locationImage;
    }

    // getters
    public long getId() {
        return this.id;
    }

    public Blob getName() {
        return this.locationImage;
    }
}
