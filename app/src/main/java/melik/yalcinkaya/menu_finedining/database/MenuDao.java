package melik.yalcinkaya.menu_finedining.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

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
    LiveData<List<MenuEntity>> getAllMenus();
}
