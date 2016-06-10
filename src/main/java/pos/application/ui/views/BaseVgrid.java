/*
 * Base GridPane class for a single column, multiple rows grid.
 */
package pos.application.ui.views;

import javafx.scene.layout.GridPane;
import pos.application.ui.UIConstants;
import pos.application.ui.UIConstraints;

public class BaseVgrid extends GridPane {

    public BaseVgrid() {
        super();
    }

    public static class BaseVgridBuilder {
        double[] heights;

        public BaseVgridBuilder(double... heights) {
            this.heights = heights;
        }

        public BaseVgrid build() {
            BaseVgrid view = new BaseVgrid();
            view.setVgap(UIConstants.GAP_PANES);
            view.setHgap(UIConstants.GAP_PANES);

            //@formatter:off
            for (double height : this.heights) {
                view.getRowConstraints()
                    .add(UIConstraints.heightConstraint(height));
            }
            view.getColumnConstraints()
                .add(UIConstraints.widthConstraint(UIConstraints._100));
            //@formatter:on

            return view;
        }
    }
}