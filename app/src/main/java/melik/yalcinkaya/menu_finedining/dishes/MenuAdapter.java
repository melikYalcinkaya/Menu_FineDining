package melik.yalcinkaya.menu_finedining.dishes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {
    private List<MenuItem> menuList;

    public MenuAdapter(List<MenuItem> menuList) {
        this.menuList = menuList;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        MenuItem item = menuList.get(position);
        holder.textView.setText(item.getTitle());

        // Eğer kategori ise bold yap
        if (item.isCategory()) {
            holder.textView.setTextSize(20);
            holder.textView.setTextColor(0xFF5E4A1D); // Kahverengi tonunda bir renk
        } else {
            holder.textView.setTextSize(16);
            holder.textView.setTextColor(0xFF000000); // Siyah
        }
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    static class MenuViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public MenuViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(android.R.id.text1);
        }
    }
}
