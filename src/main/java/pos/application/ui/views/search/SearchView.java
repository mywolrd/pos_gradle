package pos.application.ui.views.search;

import javafx.scene.control.TextField;
import pos.application.ui.UIConstraints;
import pos.application.ui.views.BaseHgrid;
import pos.application.ui.views.input.KeyPadView;

public class SearchView<T> extends BaseHgrid {

    private SearchInputResultView<T> searchResultView;
    private KeyPadView keyPadView;

    public SearchView(SearchViewBuilder<T> builder, double... widths) {
        super(widths);

        this.searchResultView = builder.searchResultView;
        this.keyPadView = builder.keyPadView;
    }

    public SearchInputResultView<T> getSearchResultView() {
        return this.searchResultView;
    }

    public KeyPadView getKeyPadView() {
        return this.keyPadView;
    }

    public TextField getInputField() {
        return this.searchResultView.getInputField();
    }

    public static class SearchViewBuilder<T> {

        private SearchInputResultView<T> searchResultView;
        private KeyPadView keyPadView;

        public SearchViewBuilder(SearchInputResultView<T> searchResultView, KeyPadView keyPadView) {
            this.searchResultView = searchResultView;
            this.keyPadView = keyPadView;
        }

        public SearchView<T> build() {
            SearchView<T> view = new SearchView<>(this, UIConstraints._40, UIConstraints._60);

            view.add(view.getSearchResultView(), 0, 0);
            view.add(view.getKeyPadView(), 1, 0);

            return view;
        }
    }
}