package melik.yalcinkaya.menu_finedining.admin.model;

public class Customer {
    private String name;
    private String email;
    private String lastVisit;
    private String tag;

    public Customer(String name, String email, String lastVisit, String tag) {
        this.name = name;
        this.email = email;
        this.lastVisit = lastVisit;
        this.tag = tag;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getLastVisit() { return lastVisit; }
    public String getTag() { return tag; }
}
