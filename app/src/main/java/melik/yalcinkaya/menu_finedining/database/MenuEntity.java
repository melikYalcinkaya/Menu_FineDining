package melik.yalcinkaya.menu_finedining.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Ignore;


@Entity(tableName = "menu_table")
public class MenuEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;
    private String description;
    private double price;
    private String category;

    // ✅ Empty constructor required by Room
    @Ignore
    public MenuEntity(String title) {
        this.title = title;
    }

    // ✅ Full constructor (used when inserting new menu items)

    public MenuEntity(String title, String description, double price, String category) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
