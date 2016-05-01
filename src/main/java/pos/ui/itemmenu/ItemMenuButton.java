package pos.ui.itemmenu;

import javafx.scene.control.Button;

import pos.model.application.ItemMenu;

public class ItemMenuButton extends Button {
	
    private ItemMenu itemMenu;
	
	private ItemMenuButton(ItemMenuButtonBuilder builder) {
	    super();
	    this.itemMenu = builder.itemMenu;
	    this.setText(this.itemMenu.getItem().getName());
	}
	
	public ItemMenu getItemMenu() {
	    return this.itemMenu;
	}
	
	public static class ItemMenuButtonBuilder {
	    
	    private ItemMenu itemMenu;
	    
	    public ItemMenuButtonBuilder itemMenu(ItemMenu itemMenu) {
	        this.itemMenu = itemMenu;
	        return this;
	    }
	    
	    public ItemMenuButton build() {
	        return new ItemMenuButton(this);
	    }
	}
	
	
	
	
}