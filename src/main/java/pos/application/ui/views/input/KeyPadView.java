package pos.application.ui.views.input;

import pos.application.ui.UIConstants;
import pos.application.ui.UIConstraints;
import pos.application.ui.views.BaseVgrid;

public class KeyPadView extends BaseVgrid {

    private ButtonPadView letterPadView;
    private ButtonPadView numberPadView;

    private KeyPadView(KeyPadViewBuilder builder, double... heights) {
        super(heights);

        this.letterPadView = builder.letterPadView;
        this.numberPadView = builder.numberPadView;
    }

    public ButtonPadView getLetterPadView() {
        return this.letterPadView;
    }

    public ButtonPadView getNumberPadView() {
        return this.numberPadView;
    }

    public static class KeyPadViewBuilder {
        private ButtonPadView letterPadView;
        private ButtonPadView numberPadView;

        public KeyPadViewBuilder(ButtonPadView letterPadView, ButtonPadView numberPadView) {
            this.letterPadView = letterPadView;
            this.numberPadView = numberPadView;
        }

        public KeyPadView build() {
            KeyPadView view = new KeyPadView(this, UIConstraints._70, UIConstraints._30);

            view.setHgap(UIConstants.GAP_BUTTONS);
            view.setVgap(50f);

            view.add(view.getLetterPadView(), 0, 0);
            view.add(view.getNumberPadView(), 0, 1);

            return view;
        }
    }
}