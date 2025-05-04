package melik.yalcinkaya.menu_finedining.admin.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import melik.yalcinkaya.menu_finedining.R;
import melik.yalcinkaya.menu_finedining.admin.adapter.DashboardAdapter;
import melik.yalcinkaya.menu_finedining.admin.model.DashboardCard;

public class AdminHomeFragment extends Fragment {

    public AdminHomeFragment() {
        super(R.layout.fragment_admin_home);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        TextView tvDayName = view.findViewById(R.id.tv_day_name);
        TextView tvPeakInfo = view.findViewById(R.id.tv_peak_info);
        TextView tvFeedback = view.findViewById(R.id.tv_feedback_summary);
        RecyclerView recycler = view.findViewById(R.id.rv_dashboard);

        // Set Day Info
        String today = new SimpleDateFormat("EEEE", Locale.getDefault()).format(new Date());
        tvDayName.setText("Today is " + today);

        int hour = Integer.parseInt(new SimpleDateFormat("HH", Locale.getDefault()).format(new Date()));
        if (hour >= 10 && hour <= 14) {
            tvPeakInfo.setText("⚠️ Peak time coming! Expect more people");
            tvPeakInfo.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
        } else if (hour >= 17) {
            tvPeakInfo.setText("Busy Dinner Hours Approaching");
            tvPeakInfo.setTextColor(getResources().getColor(android.R.color.holo_red_light));
        } else {
            tvPeakInfo.setText("Less busy hours");
            tvPeakInfo.setTextColor(getResources().getColor(android.R.color.darker_gray));
        }

        // Fake Feedback for now
        tvFeedback.setText("Recent Feedback: 'Fast delivery and great taste!'");

        // Dashboard Setup
        List<DashboardCard> cards = new ArrayList<>();
        cards.add(new DashboardCard(R.drawable.ic_menu, "Menus", 12));
        cards.add(new DashboardCard(R.drawable.ic_category, "Categories", 5));
        cards.add(new DashboardCard(R.drawable.ic_desk, "Desks", 15));
        cards.add(new DashboardCard(R.drawable.ic_reservation, "Reservations", 8));
        cards.add(new DashboardCard(R.drawable.ic_customers, "Customers", 21));
        cards.add(new DashboardCard(R.drawable.ic_delivery, "Deliveries", 6));
        cards.add(new DashboardCard(R.drawable.ic_feedback, "Feedbacks", 13));

        recycler.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        recycler.setAdapter(new DashboardAdapter(cards));
    }
}
