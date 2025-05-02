package melik.yalcinkaya.menu_finedining.database;

import android.app.Application;
import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MenuRepository {
    private MenuDao menuDao;
    private LiveData<List<MenuEntity>> allMenuItems;
    private ExecutorService executorService;

    public MenuRepository(Application application) {
        MenuDatabase db = MenuDatabase.getInstance(application);
        menuDao = db.menuDao();
        allMenuItems = menuDao.getAllMenus();
        executorService = Executors.newSingleThreadExecutor();
    }

    public LiveData<List<MenuEntity>> getAllMenuItems() {
        return allMenuItems;
    }

    public void insert(MenuEntity menuItem) {
        executorService.execute(() -> menuDao.insert(menuItem));
    }

    public void update(MenuEntity menuItem) {
        executorService.execute(() -> menuDao.update(menuItem));
    }

    public void delete(MenuEntity menuItem) {
        executorService.execute(() -> menuDao.delete(menuItem));
    }
}
