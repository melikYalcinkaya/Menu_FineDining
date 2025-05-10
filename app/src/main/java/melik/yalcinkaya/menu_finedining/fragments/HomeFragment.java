package melik.yalcinkaya.menu_finedining.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

import melik.yalcinkaya.menu_finedining.R;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        TextView title = view.findViewById(R.id.textView_title);
        TextView description = view.findViewById(R.id.textView_description);

        // Get saved language
        SharedPreferences prefs = requireActivity().getSharedPreferences("AppPreferences", 0);
        String lang = prefs.getString("selected_language", "en");

        // Set text based on language
        if (lang.equals("tr")) {
            title.setText(getString(R.string.restaurant_title_tr));
            description.setText(getString(R.string.restaurant_description_tr));
        } else if (lang.equals("ar")) {
            title.setText(getString(R.string.restaurant_title_ar));
            description.setText(getString(R.string.restaurant_description_ar));
        } else {
            // Default to English
            title.setText(getString(R.string.restaurant_title));
            description.setText(getString(R.string.restaurant_description));
        }

        return view;
    }
}