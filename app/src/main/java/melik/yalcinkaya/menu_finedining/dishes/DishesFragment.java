package melik.yalcinkaya.menu_finedining.dishes;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import melik.yalcinkaya.menu_finedining.MenuItem;
import melik.yalcinkaya.menu_finedining.home.MenuAdapter;
import melik.yalcinkaya.menu_finedining.R;

public class DishesFragment extends Fragment {

    private RecyclerView recyclerView;
    private MenuAdapter adapter;
    private List<MenuItem> menuList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dishes, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        menuList = new ArrayList<>();

        // 🍽 Dishes Section
        menuList.add(new MenuItem("🍽 Breakfast Specials", true));
        menuList.add(new MenuItem("Traditional Breakfast — $8.99", false));
        menuList.add(new MenuItem("Village Breakfast — $9.49", false));
        menuList.add(new MenuItem("Continental Breakfast — $7.99", false));

        menuList.add(new MenuItem("🔥 Hot Dishes", true));
        menuList.add(new MenuItem("Menemen (Scrambled Eggs with Veggies) — $6.99", false));
        menuList.add(new MenuItem("Cheese Omelette — $5.99", false));
        menuList.add(new MenuItem("Mushroom Omelette — $6.49", false));
        menuList.add(new MenuItem("Grilled Halloumi — $4.99", false));
        menuList.add(new MenuItem("Pancakes with Maple Syrup — $5.49", false));

        menuList.add(new MenuItem("🍰 Desserts", true));
        menuList.add(new MenuItem("Honey & Clotted Cream — $4.99", false));
        menuList.add(new MenuItem("Chocolate Pancakes — $5.49", false));
        menuList.add(new MenuItem("Baklava — $4.49", false));
        menuList.add(new MenuItem("Fruit Salad — $3.99", false));

        // 🥤 Drinks Section
        menuList.add(new MenuItem("🥤 Beverages", true));
        menuList.add(new MenuItem("Fresh Orange Juice — $2.99", false));
        menuList.add(new MenuItem("Turkish Coffee — $2.49", false));
        menuList.add(new MenuItem("Espresso — $2.29", false));
        menuList.add(new MenuItem("Cappuccino — $3.49", false));
        menuList.add(new MenuItem("Herbal Tea — $2.19", false));
        menuList.add(new MenuItem("Mineral Water — $1.50", false));

        adapter = new MenuAdapter(menuList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
