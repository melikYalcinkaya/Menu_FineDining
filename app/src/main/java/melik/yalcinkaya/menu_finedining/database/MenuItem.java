package melik.yalcinkaya.menu_finedining.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "menu_items")
public class MenuItem {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;
    private boolean isCategory;

    // Constructor
    public MenuItem(String title, boolean isCategory) {
        this.title = title;
        this.isCategory = isCategory;
    }

    // Getter and Setter methods
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public boolean isCategory() { return isCategory; }
    public void setCategory(boolean category) { isCategory = category; }
}
