package pos.javafx.application.component.views.input;

import pos.javafx.application.component.UIConstants;
import pos.javafx.application.component.views.BaseVgrid;

public class KeyboardView extends BaseVgrid {

    private ButtonsView letterPadView;
    private ButtonsView numberPadView;

    private KeyboardView(KeyPadViewBuilder builder, double... heights) {
        super(heights);

        this.letterPadView = builder.letterPadView;
        this.numberPadView = builder.numberPadView;
    }

    public ButtonsView getLetterPadView() {
        return this.letterPadView;
    }

    public ButtonsView getNumberPadView() {
        return this.numberPadView;
    }

    public static class KeyPadViewBuilder {
        private ButtonsView letterPadView;
        private ButtonsView numberPadView;

        public KeyPadViewBuilder(ButtonsView letterPadView, ButtonsView numberPadView) {
            this.letterPadView = letterPadView;
            this.numberPadView = numberPadView;
        }

        public KeyboardView build() {
            KeyboardView view = new KeyboardView(this, UIConstants._70, UIConstants._30);

            view.setHgap(UIConstants.GAP_BUTTONS);
            view.setVgap(50f);

            view.add(view.getLetterPadView(), 0, 0);
            view.add(view.getNumberPadView(), 0, 1);

            return view;
        }
    }
}