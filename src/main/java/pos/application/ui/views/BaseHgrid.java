/*
 * Base GridPane class for a single row, multiple columns grid.
 */
package pos.application.ui.views;

import javafx.scene.layout.GridPane;
import pos.application.ui.UIConstants;
import pos.application.ui.UIConstraints;

public class BaseHgrid extends GridPane {

    public BaseHgrid(double... widths) {
        super();

        this.setVgap(UIConstants.GAP_PANES);
        this.setHgap(UIConstants.GAP_PANES);

        //@formatter:off
        for (double width : widths) {
            this.getColumnConstraints()
                .add(UIConstraints.widthConstraint(width));
        }
        this.getRowConstraints()
            .add(UIConstraints.heightConstraint(UIConstraints._100));
        //@formatter:on
    }
}