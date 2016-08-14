package pos.javafx.application.component.views.search;

import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import pos.javafx.application.component.UIConstants;
import pos.javafx.application.component.views.BaseVgrid;

public class SearchInputResultView<T> extends BaseVgrid {

    private SearchResultView<T> searchResultView;
    private TextField textField;

    public SearchInputResultView(SearchInputResultViewBuilder<T> builder, double... heights) {
        super(heights);

        this.searchResultView = builder.searchResultView;
        this.textField = builder.textField;
    }

    public SearchResultView<T> getSearchResultView() {
        return this.searchResultView;
    }

    public TextField getInputField() {
        return this.textField;
    }

    public static class SearchInputResultViewBuilder<T> {
        private SearchResultView<T> searchResultView;
        private TextField textField;

        public SearchInputResultViewBuilder(SearchResultView<T> searchResultView) {
            this.searchResultView = searchResultView;
            this.textField = new TextField();
        }

        public SearchInputResultView<T> build() {
            SearchInputResultView<T> view = new SearchInputResultView<>(this, UIConstants._35, UIConstants._65);

            StackPane input = new StackPane();
            input.getChildren().add(view.getInputField());

            view.add(input, 0, 0);
            view.add(view.getSearchResultView(), 0, 1);

            return view;
        }
    }

}