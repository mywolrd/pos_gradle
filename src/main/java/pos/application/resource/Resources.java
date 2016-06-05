package pos.application.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.scene.layout.Pane;

/**
 * Initialized at startup, destroyed at close.
 */
@Component
public class Resources {

    // Attach rootPane to the JavaFX Scene and add other panes to this root.
    private Pane root = new Pane();

    @Autowired
    private POSCart cart;

    public Pane getRootPane() {
        return this.root;
    }

    public POSCart getCart() {
        return this.cart;
    }

    public void setItemMenuPane(Pane itemMenuPane) {
        this.root.getChildren().add(itemMenuPane);
    }
}