package melik.yalcinkaya.menu_finedining.admin.utils;

import java.util.ArrayList;
import java.util.List;

import melik.yalcinkaya.menu_finedining.admin.model.Customer;

public class SampleCustomerData {
    public static List<Customer> generateSampleCustomers() {
        List<Customer> list = new ArrayList<>();

        list.add(new Customer("John Doe", "john@example.com", "April 20, 2025", "VIP"));
        list.add(new Customer("Emily Smith", "emily@example.com", "May 1, 2025", "Frequent"));
        list.add(new Customer("Chris Johnson", "chrisj@example.com", "April 30, 2025", "New"));
        list.add(new Customer("Sarah Lee", "sarah.lee@example.com", "April 25, 2025", "Big Spender"));

        return list;
    }
}
