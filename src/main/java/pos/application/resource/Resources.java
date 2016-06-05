package pos.application.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.scene.layout.Pane;

/**
 * Initialized at startup, destroyed at close.
 */
@Component
public class Resources {
    // TODO Remove comments when done.

    // Attach rootPane to the JavaFX Scene and add other panes to this root.
    private Pane root;

    // For POS, only a single cart is used at any given time.
    @Autowired
    private POSCart cart;

    public POSCart getCart() {
        return this.cart;
    }

}