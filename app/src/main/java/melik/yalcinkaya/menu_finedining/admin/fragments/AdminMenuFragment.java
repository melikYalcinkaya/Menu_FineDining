package melik.yalcinkaya.menu_finedining.admin.fragments;

import android.app.AlertDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.concurrent.Executors;

import melik.yalcinkaya.menu_finedining.R;
import melik.yalcinkaya.menu_finedining.admin.adapter.AdminMenuAdapter;
import melik.yalcinkaya.menu_finedining.database.MenuDao;
import melik.yalcinkaya.menu_finedining.database.MenuDatabase;
import melik.yalcinkaya.menu_finedining.database.MenuEntity;

public class AdminMenuFragment extends Fragment {

    private RecyclerView rvMenu;
    private AdminMenuAdapter adapter;
    private MenuDao menuDao;

    public AdminMenuFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_admin_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        rvMenu = view.findViewById(R.id.recycler_admin_menu);
        menuDao = MenuDatabase.getInstance(requireContext()).menuDao();

        rvMenu.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter = new AdminMenuAdapter(new ArrayList<>(), new AdminMenuAdapter.OnMenuItemClickListener() {
            @Override
            public void onEdit(MenuEntity menu) {
                showMenuDialog(true, menu);
            }

            @Override
            public void onDelete(MenuEntity menu) {
                Executors.newSingleThreadExecutor().execute(() -> {
                    menuDao.delete(menu);
                });
                Toast.makeText(getContext(), "Menu item deleted", Toast.LENGTH_SHORT).show();
            }
        });
        rvMenu.setAdapter(adapter);

        // ✅ Observe LiveData from Room and update adapter
        menuDao.getAllMenus().observe(getViewLifecycleOwner(), menus -> {
            adapter.setMenuList(menus);
        });

        view.findViewById(R.id.fab_add_item).setOnClickListener(v -> {
            showMenuDialog(false, null);
        });

        //Static adding menus
        /*Executors.newSingleThreadExecutor().execute(() -> {
            if (menuDao.getAllMenus().getValue() == null || menuDao.getAllMenus().getValue().isEmpty()) {
                menuDao.insert(new MenuEntity("Lamb Chops", "Grilled with rosemary", 18.5, "Main"));
                menuDao.insert(new MenuEntity("Tomato Soup", "Fresh tomatoes and herbs", 6.0, "Starter"));
                menuDao.insert(new MenuEntity("Chocolate Lava Cake", "With vanilla ice cream", 7.5, "Dessert"));
            }
        });*/



    }

    private void showMenuDialog(boolean isEdit, @Nullable MenuEntity existing) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle(isEdit ? "Edit Menu Item" : "Add Menu Item");

        View dialogView = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_add_edit_menu_item, null);
        builder.setView(dialogView);

        EditText etTitle = dialogView.findViewById(R.id.et_menu_title);
        EditText etPrice = dialogView.findViewById(R.id.et_menu_price);
        EditText etCategory = dialogView.findViewById(R.id.et_menu_category);

        if (isEdit && existing != null) {
            etTitle.setText(existing.getTitle());
            etPrice.setText(String.valueOf(existing.getPrice()));
            etCategory.setText(existing.getCategory());
        }

        builder.setPositiveButton(isEdit ? "Update" : "Add", (dialog, which) -> {
            String title = etTitle.getText().toString().trim();
            String priceStr = etPrice.getText().toString().trim();
            String category = etCategory.getText().toString().trim();

            if (title.isEmpty() || priceStr.isEmpty() || category.isEmpty()) {
                Toast.makeText(getContext(), "All fields must be filled", Toast.LENGTH_SHORT).show();
                return;
            }

            double price;
            try {
                price = Double.parseDouble(priceStr);
            } catch (NumberFormatException e) {
                Toast.makeText(getContext(), "Invalid price", Toast.LENGTH_SHORT).show();
                return;
            }

            if (isEdit && existing != null) {
                existing.setTitle(title);
                existing.setPrice(price);
                existing.setCategory(category);
                Executors.newSingleThreadExecutor().execute(() -> {
                    menuDao.update(existing);
                });
                Toast.makeText(getContext(), "Updated successfully", Toast.LENGTH_SHORT).show();
            } else {
                MenuEntity newItem = new MenuEntity(title, "", price, category);
                Executors.newSingleThreadExecutor().execute(() -> {
                    menuDao.insert(newItem);
                });
                Toast.makeText(getContext(), "Added successfully", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());
        builder.show();
    }

}

