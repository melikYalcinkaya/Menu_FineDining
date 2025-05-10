package melik.yalcinkaya.menu_finedining.admin.model;

public class DashboardCard {
    private int iconRes;
    private String label;
    private int count;

    public DashboardCard(int iconRes, String label, int count) {
        this.iconRes = iconRes;
        this.label = label;
        this.count = count;
    }

    public int getIconRes() {
        return iconRes;
    }

    public String getLabel() {
        return label;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
