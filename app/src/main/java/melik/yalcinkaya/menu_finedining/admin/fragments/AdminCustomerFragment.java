package melik.yalcinkaya.menu_finedining.admin.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import melik.yalcinkaya.menu_finedining.R;
import melik.yalcinkaya.menu_finedining.admin.adapter.CustomerAdapter;
import melik.yalcinkaya.menu_finedining.admin.model.Customer;
import melik.yalcinkaya.menu_finedining.admin.utils.SampleCustomerData;

public class AdminCustomerFragment extends Fragment {

    private RecyclerView recyclerView;
    private CustomerAdapter adapter;
    private List<Customer> customerList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin_customer, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewCustomers);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        customerList = SampleCustomerData.generateSampleCustomers();
        adapter = new CustomerAdapter(customerList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
