package pos.application.ui.views.input;

import javafx.scene.layout.GridPane;
import pos.application.ui.UIConstants;
import pos.application.ui.UIConstraints;

public class KeyPadView extends GridPane {

    private LetterPadView letterPadView;
    private NumberPadView numberPadView;

    private KeyPadView(KeyPadViewBuilder builder) {
        this.letterPadView = builder.letterPadView;
        this.numberPadView = builder.numberPadView;
    }

    public LetterPadView getLetterPadView() {
        return this.letterPadView;
    }

    public NumberPadView getNumberPadView() {
        return this.numberPadView;
    }

    public static class KeyPadViewBuilder {
        private LetterPadView letterPadView;
        private NumberPadView numberPadView;

        public KeyPadViewBuilder(LetterPadView letterPadView, NumberPadView numberPadView) {
            this.letterPadView = letterPadView;
            this.numberPadView = numberPadView;
        }

        public KeyPadView build() {
            KeyPadView view = new KeyPadView(this);
            //@formatter:off
            view.getRowConstraints()
                .addAll(UIConstraints.heightConstraint(UIConstraints._70), 
                        UIConstraints.heightConstraint(UIConstraints._30));
            view.getColumnConstraints()
                .add(UIConstraints.widthConstraint(UIConstraints._100));
            
            view.setHgap(UIConstants.GAP_BUTTONS);
            view.setVgap(50f);
            
            view.add(view.getLetterPadView(), 0, 0);
            view.add(view.getNumberPadView(), 0, 1);
            //@formatter:on
            return view;
        }
    }
}