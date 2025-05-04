package melik.yalcinkaya.menu_finedining.admin.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import melik.yalcinkaya.menu_finedining.R;
import melik.yalcinkaya.menu_finedining.admin.model.DashboardCard;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.ViewHolder> {

    private final List<DashboardCard> dashboardList;

    public DashboardAdapter(List<DashboardCard> dashboardList) {
        this.dashboardList = dashboardList;
    }

    @NonNull
    @Override
    public DashboardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dashboard_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DashboardAdapter.ViewHolder holder, int position) {
        DashboardCard card = dashboardList.get(position);
        holder.icon.setImageResource(card.getIconRes());
        holder.label.setText(card.getLabel());
        holder.count.setText(String.valueOf(card.getCount()));
    }

    @Override
    public int getItemCount() {
        return dashboardList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView label, count;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.dashboard_icon);
            label = itemView.findViewById(R.id.dashboard_label);
            count = itemView.findViewById(R.id.dashboard_count);
        }
    }
}
