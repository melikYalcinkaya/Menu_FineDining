package melik.yalcinkaya.menu_finedining.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Delete;

import java.util.List;

@Dao
public interface MenuItemDao {

    @Insert
    void insert(MenuItem menuItem);

    @Update
    void update(MenuItem menuItem);

    @Delete
    void delete(MenuItem menuItem);

    @Query("SELECT * FROM menu_items ORDER BY id ASC")
    LiveData<List<MenuItem>> getAllMenuItems();
}
