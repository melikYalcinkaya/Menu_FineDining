package melik.yalcinkaya.menu_finedining;

public class MenuItem {
    private String title;
    private boolean isCategory; // if true ==> title, false ==> product

    public MenuItem(String title, boolean isCategory) {
        this.title = title;
        this.isCategory = isCategory;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCategory() {
        return isCategory;
    }
}