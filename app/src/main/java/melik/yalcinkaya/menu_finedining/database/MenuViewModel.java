package melik.yalcinkaya.menu_finedining.database;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MenuViewModel extends AndroidViewModel {

    private MenuRepository repository;
    private LiveData<List<MenuEntity>> allMenuItems;

    public MenuViewModel(@NonNull Application application) {
        super(application);
        repository = new MenuRepository(application);
        allMenuItems = repository.getAllMenuItems();
    }

    public LiveData<List<MenuEntity>> getAllMenuItems() {
        return allMenuItems;
    }

    public void insert(MenuEntity item) {
        repository.insert(item);
    }

    public void update(MenuEntity item) {
        repository.update(item);
    }

    public void delete(MenuEntity item) {
        repository.delete(item);
    }
}
