/*
 * Base GridPane class for a single row, multiple columns grid.
 */
package pos.javafx.application.ui.views;

import pos.javafx.application.ui.UIConstants;
import pos.javafx.application.ui.UIConstraints;

public class BaseHgrid extends BaseGrid {

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
            .add(UIConstraints.heightConstraint(UIConstants._100));
        //@formatter:on
    }
}