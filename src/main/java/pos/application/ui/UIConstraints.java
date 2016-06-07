package pos.application.ui;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;

public class UIConstraints {

    public static final double _25 = 25f;
    public static final double _35 = 35f;
    public static final double _45 = 45f;
    public static final double _55 = 55f;
    public static final double _65 = 65f;
    public static final double _75 = 75f;

    public static ColumnConstraints widthConstraint(double percent) {
        ColumnConstraints constraint = new ColumnConstraints();
        constraint.setPercentWidth(percent);
        return constraint;
    }

    public static RowConstraints heightConstraint(double percent) {
        RowConstraints constraint = new RowConstraints();
        constraint.setPercentHeight(percent);
        return constraint;
    }
}