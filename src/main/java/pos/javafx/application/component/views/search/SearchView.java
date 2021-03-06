package pos.javafx.application.component.views.search;

import javafx.scene.control.TextField;
import pos.javafx.application.component.UIConstants;
import pos.javafx.application.component.views.BaseHgrid;
import pos.javafx.application.component.views.input.KeyboardView;

public class SearchView<T> extends BaseHgrid {

    private SearchInputResultView<T> searchResultView;
    private KeyboardView keyPadView;

    public SearchView(SearchViewBuilder<T> builder, double... widths) {
        super(widths);

        this.searchResultView = builder.searchResultView;
        this.keyPadView = builder.keyPadView;
    }

    public SearchInputResultView<T> getSearchResultView() {
        return this.searchResultView;
    }

    public KeyboardView getKeyPadView() {
        return this.keyPadView;
    }

    public TextField getInputField() {
        return this.searchResultView.getInputField();
    }

    public static class SearchViewBuilder<T> {

        private SearchInputResultView<T> searchResultView;
        private KeyboardView keyPadView;

        public SearchViewBuilder(SearchInputResultView<T> searchResultView, KeyboardView keyPadView) {
            this.searchResultView = searchResultView;
            this.keyPadView = keyPadView;
        }

        public SearchView<T> build() {
            SearchView<T> view = new SearchView<>(this, UIConstants._40, UIConstants._60);

            view.add(view.getSearchResultView(), 0, 0);
            view.add(view.getKeyPadView(), 1, 0);

            return view;
        }
    }
}