package melik.yalcinkaya.menu_finedining.admin.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import melik.yalcinkaya.menu_finedining.R;
import melik.yalcinkaya.menu_finedining.database.MenuEntity;

public class AdminMenuAdapter extends RecyclerView.Adapter<AdminMenuAdapter.MenuViewHolder> {

    public interface OnMenuItemClickListener {
        void onEdit(MenuEntity menu);
        void onDelete(MenuEntity menu);
    }

    private List<MenuEntity> menuList;
    private OnMenuItemClickListener listener;

    public AdminMenuAdapter(List<MenuEntity> menuList, OnMenuItemClickListener listener) {
        this.menuList = menuList;
        this.listener = listener;
    }

    public void setMenuList(List<MenuEntity> menuList) {
        this.menuList = menuList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.admin_menu_item, parent, false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        MenuEntity menu = menuList.get(position);
        holder.title.setText(menu.getTitle());
        holder.price.setText(String.format("$%.2f", menu.getPrice()));
        holder.category.setText(menu.getCategory());

        holder.edit.setOnClickListener(v -> listener.onEdit(menu));
        holder.delete.setOnClickListener(v -> listener.onDelete(menu));
    }


    @Override
    public int getItemCount() {
        return menuList == null ? 0 : menuList.size();
    }

    static class MenuViewHolder extends RecyclerView.ViewHolder {
        TextView title, price, category;
        Button edit, delete;

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_menu_title);
            price = itemView.findViewById(R.id.tv_menu_price);
            category = itemView.findViewById(R.id.tv_menu_category);
            edit = itemView.findViewById(R.id.btn_edit);
            delete = itemView.findViewById(R.id.btn_delete);
        }
    }

}
