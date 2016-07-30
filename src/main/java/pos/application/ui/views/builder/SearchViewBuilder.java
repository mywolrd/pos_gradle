package pos.application.ui.views.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pos.application.ui.views.search.SearchInputResultView;
import pos.application.ui.views.search.SearchResultView;
import pos.application.ui.views.search.SearchView;

@Component
public class SearchViewBuilder {

    @Autowired
    private KeyboardViewBuilder keyPadViewBuilder;

    public <T> SearchView<T> buildSearchView() {
        return new SearchView.SearchViewBuilder<T>(this.buildSearchInputResultView(), keyPadViewBuilder.buildKeyboardView()).build();
    }

    public <T> SearchInputResultView<T> buildSearchInputResultView() {
        return new SearchInputResultView.SearchInputResultViewBuilder<T>(this.buildSearchResultView()).build();
    }

    public <T> SearchResultView<T> buildSearchResultView() {
        return new SearchResultView.SearchResultViewBuilder<T>().build();
    }
}