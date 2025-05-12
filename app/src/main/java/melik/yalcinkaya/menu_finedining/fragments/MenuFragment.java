package melik.yalcinkaya.menu_finedining.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import melik.yalcinkaya.menu_finedining.R;

public class MenuFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle bs) {
        View view = inflater.inflate(R.layout.fragment_dishes, parent, false);

        RecyclerView rv = view.findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(requireContext()));

        // build unified list
        List<DishItem> list = new ArrayList<>();

        // Breakfast
        list.add(new DishItem("Breakfast", true));
        list.add(new DishItem("Classic English Breakfast — $12.99", false));
        list.add(new DishItem("Avocado Toast — $9.49", false));
        list.add(new DishItem("Pancake Stack — $8.99", false));
        list.add(new DishItem("French Toast — $9.49", false));
        list.add(new DishItem("Eggs Benedict — $11.99", false));
        list.add(new DishItem("Oatmeal Bowl — $6.99", false));
        list.add(new DishItem("Granola Parfait — $7.49", false));
        list.add(new DishItem("Bagel & Cream Cheese — $4.99", false));
        list.add(new DishItem("Breakfast Burrito — $10.99", false));
        list.add(new DishItem("Fruit Platter — $7.99", false));

        // Dinner
        list.add(new DishItem("Dinner", true));
        list.add(new DishItem("Grilled Salmon — $18.99", false));
        list.add(new DishItem("Sirloin Steak — $24.99", false));
        list.add(new DishItem("Chicken Parmesan — $16.99", false));
        list.add(new DishItem("Lamb Chops — $22.49", false));
        list.add(new DishItem("Vegetarian Lasagna — $14.99", false));
        list.add(new DishItem("Shrimp Scampi — $19.99", false));
        list.add(new DishItem("Beef Stroganoff — $17.99", false));
        list.add(new DishItem("Pork Tenderloin — $18.49", false));
        list.add(new DishItem("Spaghetti Carbonara — $13.99", false));

        // Desserts
        list.add(new DishItem("Desserts", true));
        list.add(new DishItem("Chocolate Lava Cake — $7.99", false));
        list.add(new DishItem("Cheesecake — $6.99", false));
        list.add(new DishItem("Tiramisu — $7.49", false));
        list.add(new DishItem("Crème Brûlée — $6.99", false));
        list.add(new DishItem("Apple Pie — $5.99", false));
        list.add(new DishItem("Ice Cream Sundae — $4.99", false));
        list.add(new DishItem("Panna Cotta — $6.49", false));
        list.add(new DishItem("Lemon Tart — $6.99", false));
        list.add(new DishItem("Strawberry Shortcake — $7.49", false));
        list.add(new DishItem("Brownie à la Mode — $5.99", false));

        // Beverages
        list.add(new DishItem("Beverages", true));
        list.add(new DishItem("Fresh Orange Juice — $3.49", false));
        list.add(new DishItem("Espresso — $2.99", false));
        list.add(new DishItem("Latte — $4.49", false));
        list.add(new DishItem("Cappuccino — $4.49", false));
        list.add(new DishItem("Iced Tea — $2.99", false));
        list.add(new DishItem("Herbal Tea — $2.49", false));
        list.add(new DishItem("Mineral Water — $1.99", false));
        list.add(new DishItem("Red Wine Glass — $6.99", false));
        list.add(new DishItem("White Wine Glass — $6.99", false));
        list.add(new DishItem("Craft Beer — $5.49", false));

        rv.setAdapter(new DishAdapter(list));
        return view;
    }
}
