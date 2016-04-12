package pos.model.application;

public class MenuDescriptor {

    public enum MenuType {
        MAIN_MENU, SUB_MENU;
    }

    private long id;
    private String name;
    private MenuType type;
}