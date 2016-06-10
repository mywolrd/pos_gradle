package pos.application.ui.views.search;

import java.util.LinkedList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;

public class SearchResultView<T> extends StackPane {

    private ObservableList<T> result;

    public SearchResultView(SearchResultViewBuilder<T> builder) {
        this.result = builder.result;
    }

    public ObservableList<T> getResult() {
        return this.result;
    }

    public void clearResult() {
        this.result.clear();
    }

    public void setResult(List<T> result) {
        this.result.clear();
        this.result.addAll(result);
    }

    public static class SearchResultViewBuilder<T> {
        private ObservableList<T> result = FXCollections.observableList(new LinkedList<T>());

        public SearchResultViewBuilder() {
        }

        public SearchResultViewBuilder<T> result(List<T> list) {
            this.result = FXCollections.observableList(list);
            return this;
        }

        public SearchResultView<T> build() {
            SearchResultView<T> view = new SearchResultView<>(this);
            view.getChildren().add(new ListView<T>(view.getResult()));
            return view;
        }
    }

}