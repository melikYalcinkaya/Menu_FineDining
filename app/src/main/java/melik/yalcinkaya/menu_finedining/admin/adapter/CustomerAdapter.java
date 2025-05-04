package melik.yalcinkaya.menu_finedining.admin.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import melik.yalcinkaya.menu_finedining.R;
import melik.yalcinkaya.menu_finedining.admin.model.Customer;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder> {

    private List<Customer> customerList;

    public CustomerAdapter(List<Customer> customerList) {
        this.customerList = customerList;
    }

    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_customer, parent, false);
        return new CustomerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerViewHolder holder, int position) {
        Customer customer = customerList.get(position);
        holder.name.setText(customer.getName());
        holder.email.setText(customer.getEmail());
        holder.lastVisit.setText("Last Visit: " + customer.getLastVisit());
        holder.tag.setText(customer.getTag());

        if (customer.getTag().equalsIgnoreCase("VIP")) {
            holder.tag.setBackgroundResource(android.R.color.holo_red_dark);
        } else {
            holder.tag.setBackgroundResource(android.R.color.darker_gray);
        }
    }

    @Override
    public int getItemCount() {
        return customerList.size();
    }

    static class CustomerViewHolder extends RecyclerView.ViewHolder {
        TextView name, email, lastVisit, tag;

        public CustomerViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textCustomerName);
            email = itemView.findViewById(R.id.textCustomerEmail);
            lastVisit = itemView.findViewById(R.id.textCustomerLastVisit);
            tag = itemView.findViewById(R.id.textCustomerTag);
        }
    }
}
