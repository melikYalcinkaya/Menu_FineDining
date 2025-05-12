package melik.yalcinkaya.menu_finedining.fragments;

public class DishItem {
    private final String title;
    private final boolean isSection;

    public DishItem(String title, boolean isSection) {
        this.title = title;
        this.isSection = isSection;
    }

    public String getTitle() {
        return title;
    }

    public boolean isSection() {
        return isSection;
    }
}
