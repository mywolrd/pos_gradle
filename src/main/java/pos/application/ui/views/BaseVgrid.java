/*
 * Base GridPane class for a single column, multiple rows grid.
 */
package pos.application.ui.views;

import javafx.scene.layout.GridPane;
import pos.application.ui.UIConstants;
import pos.application.ui.UIConstraints;

public class BaseVgrid extends GridPane {

    public BaseVgrid(double... heights) {
        super();

        this.setVgap(UIConstants.GAP_PANES);
        this.setHgap(UIConstants.GAP_PANES);

        //@formatter:off
        for (double height : heights) {
            this.getRowConstraints()
                .add(UIConstraints.heightConstraint(height));
        }
        this.getColumnConstraints()
            .add(UIConstraints.widthConstraint(UIConstraints._100));
        //@formatter:on
    }
}