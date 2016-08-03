/*
 * Base GridPane class for a single column, multiple rows grid.
 */
package pos.javafx.application.ui.views;

import pos.javafx.application.ui.UIConstants;
import pos.javafx.application.ui.UIConstraints;

public class BaseVgrid extends BaseGrid {

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
            .add(UIConstraints.widthConstraint(UIConstants._100));
        //@formatter:on
    }
}