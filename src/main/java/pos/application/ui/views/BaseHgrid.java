/*
 * Base GridPane class for a single row, multiple columns grid.
 */
package pos.application.ui.views;

import javafx.scene.layout.GridPane;
import pos.application.ui.UIConstants;
import pos.application.ui.UIConstraints;

public class BaseHgrid extends GridPane {

    public BaseHgrid() {
        super();
    }

    public static class BaseHgridBuilder {
        double[] widths;

        public BaseHgridBuilder(double... widths) {
            this.widths = widths;
        }

        public BaseHgrid build() {
            BaseHgrid view = new BaseHgrid();
            view.setVgap(UIConstants.GAP_PANES);
            view.setHgap(UIConstants.GAP_PANES);

            //@formatter:off
            for (double width : this.widths) {
                view.getColumnConstraints()
                    .add(UIConstraints.widthConstraint(width));
            }
            view.getRowConstraints()
                .add(UIConstraints.heightConstraint(UIConstraints._100));
            //@formatter:on

            return view;
        }
    }
}