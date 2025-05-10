package melik.yalcinkaya.menu_finedining.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import melik.yalcinkaya.menu_finedining.R;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Bu fragment sadece statik metin ve görsel içeren bir tanıtım sayfasıdır
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}
