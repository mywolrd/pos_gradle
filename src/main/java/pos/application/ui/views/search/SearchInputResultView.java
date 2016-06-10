package pos.application.ui.views.search;

import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import pos.application.ui.UIConstraints;

public class SearchInputResultView<T> extends GridPane {

    private SearchResultView<T> searchResultView;
    private TextField textField;

    public SearchInputResultView(SearchInputResultViewBuilder<T> builder) {
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
            SearchInputResultView<T> view = new SearchInputResultView<>(this);

            //@formatter:off
            view.getColumnConstraints()
                .add(UIConstraints.widthConstraint(UIConstraints._100));

            view.getRowConstraints()
                .addAll(UIConstraints.heightConstraint(UIConstraints._35),
                        UIConstraints.heightConstraint(UIConstraints._65));
            
            StackPane input = new StackPane();
            input.getChildren().add(view.getInputField());
            
            view.add(input, 0, 0);
            view.add(view.getSearchResultView(), 0, 1);
            //@formatter:on

            return view;
        }
    }

}