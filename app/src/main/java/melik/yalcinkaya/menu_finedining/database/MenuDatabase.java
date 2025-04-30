package melik.yalcinkaya.menu_finedining.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {MenuEntity.class}, version = 1)
public abstract class MenuDatabase extends RoomDatabase {
    private static volatile MenuDatabase instance;

    public abstract MenuDao menuDao();

    public static synchronized MenuDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    MenuDatabase.class,
                    "menu_database"
            ).fallbackToDestructiveMigration().build();
        }
        return instance;
    }
}
