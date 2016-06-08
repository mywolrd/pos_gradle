package pos.application.ui.views.builder;

import org.springframework.stereotype.Component;

import pos.application.ui.views.input.KeyPadView;
import pos.application.ui.views.input.LetterPadView;
import pos.application.ui.views.input.NumberPadView;

@Component
public class KeyPadViewBuilder {

    public KeyPadView buildKeyPadView() {
        LetterPadView lView = new LetterPadView.LetterPadViewBuilder().build();
        NumberPadView nView = new NumberPadView.NumberPadViewBuilder().build();
        return new KeyPadView.KeyPadViewBuilder(lView, nView).build();
    }

}