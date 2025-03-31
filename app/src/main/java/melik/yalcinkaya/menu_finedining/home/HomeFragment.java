package melik.yalcinkaya.menu_finedining.home;

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
import melik.yalcinkaya.menu_finedining.R;


public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private MenuAdapter adapter;
    private List<MenuItem> menuList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        menuList = new ArrayList<>();
        menuList.add(new MenuItem("🍽 Geleneksel Kahvaltı", true));
        menuList.add(new MenuItem("Serpme Kahvaltı",false));
        menuList.add(new MenuItem("Köy Kahvaltısı",false));

        menuList.add(new MenuItem("🔥 Sıcak Kahvaltılar", true));
        menuList.add(new MenuItem("Menemen",false));
        menuList.add(new MenuItem("Omlet Çeşitleri",false));

        menuList.add(new MenuItem("🍰 Tatlılar", true));
        menuList.add(new MenuItem("Bal Kaymak",false));
        menuList.add(new MenuItem("Çikolatalı Krep",false));

        menuList.add(new MenuItem("🥤 İçecekler", true));
        menuList.add(new MenuItem("Taze Sıkılmış Portakal Suyu",false));
        menuList.add(new MenuItem("Türk Kahvesi",false));

        adapter = new MenuAdapter(menuList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}