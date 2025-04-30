package melik.yalcinkaya.menu_finedining.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "menu_table")
public class MenuEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String title;
    public boolean isCategory;

    public MenuEntity(String title, boolean isCategory) {
        this.title = title;
        this.isCategory = isCategory;
    }
}
