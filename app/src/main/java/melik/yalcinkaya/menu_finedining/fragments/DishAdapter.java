package melik.yalcinkaya.menu_finedining.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import melik.yalcinkaya.menu_finedining.R;

public class DishAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<DishItem> items;
    private static final int TYPE_SECTION = 0;
    private static final int TYPE_ITEM    = 1;

    public DishAdapter(List<DishItem> items) {
        this.items = items;
    }

    @Override public int getItemViewType(int position) {
        return items.get(position).isSection() ? TYPE_SECTION : TYPE_ITEM;
    }

    @NonNull @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layout = (viewType == TYPE_SECTION)
                ? R.layout.item_section_header
                : R.layout.item_menu_entry;
        View v = LayoutInflater.from(parent.getContext())
                .inflate(layout, parent, false);
        return new RecyclerView.ViewHolder(v) {};
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int pos) {
        DishItem di = items.get(pos);
        TextView tv = holder.itemView.findViewById(
                di.isSection() ? R.id.tvSectionTitle : R.id.tvEntryTitle
        );
        tv.setText(di.getTitle());
    }

    @Override public int getItemCount() { return items.size(); }
}
