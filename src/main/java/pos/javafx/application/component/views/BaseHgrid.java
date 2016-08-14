/*
 * Base GridPane class for a single row, multiple columns grid.
 */
package pos.javafx.application.component.views;

import pos.javafx.application.component.UIConstants;
import pos.javafx.application.component.UIConstraints;

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