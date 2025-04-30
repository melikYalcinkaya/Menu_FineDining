package melik.yalcinkaya.menu_finedining.database;

import androidx.lifecycle.LiveData;
import androidx.room.*;

import java.util.List;

@Dao
public interface MenuDao {
    @Insert
    void insert(MenuEntity menuEntity);

    @Update
    void update(MenuEntity menuEntity);

    @Delete
    void delete(MenuEntity menuEntity);

    @Query("SELECT * FROM menu_table ORDER BY id ASC")
    LiveData<List<MenuEntity>> getAllMenuItems();
}
