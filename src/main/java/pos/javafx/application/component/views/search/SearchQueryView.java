package pos.javafx.application.component.views.search;

import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

public class SearchQueryView extends StackPane {

    private TextField searchQuery;

    private SearchQueryView(SearchQueryViewBuilder builder) {
        this.searchQuery = builder.textField;
    }

    public static class SearchQueryViewBuilder {

        private TextField textField;

        public SearchQueryViewBuilder() {
            this.textField = new TextField();
        }

        public SearchQueryView build() {
            return new SearchQueryView(this);
        }
    }
}