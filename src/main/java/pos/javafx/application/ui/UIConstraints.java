package pos.javafx.application.ui;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;

public class UIConstraints {

    public static final double _25 = 25f;
    public static final double _35 = 35f;
    public static final double _45 = 45f;
    public static final double _55 = 55f;
    public static final double _65 = 65f;
    public static final double _75 = 75f;

    public static final double _10 = 10f;
    public static final double _20 = 20f;
    public static final double _30 = 30f;
    public static final double _40 = 40f;
    public static final double _50 = 50f;
    public static final double _60 = 60f;
    public static final double _70 = 70f;
    public static final double _80 = 80f;
    public static final double _90 = 90f;

    public static final double _100 = 100f;

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