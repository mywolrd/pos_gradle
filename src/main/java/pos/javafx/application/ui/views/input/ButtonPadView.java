package pos.javafx.application.ui.views.input;

import java.util.List;
import java.util.stream.IntStream;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import pos.javafx.application.ui.UIConstants;
import pos.javafx.application.ui.UIConstraints;

public class ButtonPadView extends GridPane {

    private List<? extends Button> buttons;
    private double vGap;
    private double hGap;
    private int numberOfColumns;

    public double getVGap() {
        return this.vGap;
    }

    public double getHGap() {
        return this.hGap;
    }

    public int getNumberOfColumns() {
        return this.numberOfColumns;
    }

    public List<? extends Button> getButtons() {
        return this.buttons;
    }

    @Override
    public void layoutChildren() {
        for (Node node : this.getChildren()) {
            if (node instanceof Button) {
                /* TODO */
                // UI settings change, do I use this or rebuild?
            }
        }
        super.layoutChildren();
    }

    private ButtonPadView(ButtonPadViewBuilder builder) {
        this.buttons = builder.buttons;
        this.vGap = builder.vGap;
        this.hGap = builder.hGap;
        this.numberOfColumns = builder.numberOfColumns;
    }

    public static class ButtonPadViewBuilder {

        private List<? extends Button> buttons;
        private double vGap = UIConstants.GAP_BUTTONS;
        private double hGap = UIConstants.GAP_BUTTONS;
        private int numberOfColumns = UIConstants.NUMBER_OF_BUTTONS_PER_ROW;

        public ButtonPadViewBuilder(List<? extends Button> buttons) {
            this.buttons = buttons;
        }

        public ButtonPadViewBuilder Vgap(double gap) {
            this.vGap = gap;
            return this;
        }

        public ButtonPadViewBuilder Hgap(double gap) {
            this.hGap = gap;
            return this;
        }

        public ButtonPadViewBuilder numberOfColumns(int c) {
            this.numberOfColumns = c;
            return this;
        }

        public ButtonPadView build() {
            ButtonPadView view = new ButtonPadView(this);

            //@formatter:off
            view.setVgap(view.getVGap());
            view.setHgap(view.getHGap());

            int c = 0;
            int r = 0;
            int numberOfColumns = view.getNumberOfColumns();
            
            for (Button button : view.getButtons()) {
                button.setMaxWidth(Double.MAX_VALUE);
                button.setMaxHeight(Double.MAX_VALUE);
                
                view.add(button, c, r);
                
                c++;
                if (c == numberOfColumns) {
                    c = 0; r++;
                }
            }
            
            double width = 100f / numberOfColumns;
            double height = 100f / (r + 1);
            
            IntStream.range(0, numberOfColumns)
                .forEach(num -> view.getColumnConstraints().add(UIConstraints.widthConstraint(width)));
            IntStream.range(0, r+1)
                .forEach(num -> view.getRowConstraints().add(UIConstraints.heightConstraint(height)));                       
            //@formatter:on

            return view;
        }
    }
}