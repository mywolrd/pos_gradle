package pos.javafx.application.ui.views.customer;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pos.javafx.application.ui.UIConstants;
import pos.javafx.application.ui.views.BaseHgrid;
import pos.javafx.application.ui.views.BaseVgrid;
import pos.model.application.Customer;
import pos.model.application.Customer.CustomerBuilder;

public class NewCustomerView extends BaseVgrid {

    private TextField firstName;
    private TextField lastName;
    private TextField number;

    private NewCustomerView(NewCustomerViewBuilder builder, double... widths) {
        super(widths);

        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.number = builder.number;
    }

    @Override
    public TextField getCurrentTextField() {
        if (this.firstName.isFocused()) {
            return this.firstName;
        } else if (this.lastName.isFocused()) {
            return this.lastName;
        } else if (this.number.isFocused()) {
            return this.number;
        }
        return null;
    }

    public Customer getNewCustomer() {
        return new CustomerBuilder(this.lastName.getText()).firstName(this.firstName.getText()).number(this.number.getText()).build();
    }

    public static class NewCustomerViewBuilder {

        private TextField firstName;
        private TextField lastName;
        private TextField number;

        public NewCustomerViewBuilder() {
            this.firstName = new TextField();
            this.lastName = new TextField();
            this.number = new TextField();
        }

        public NewCustomerView build() {
            NewCustomerView view = new NewCustomerView(this, UIConstants._20, UIConstants._20, UIConstants._20, UIConstants._40);

            BaseHgrid lastName = new BaseHgrid(UIConstants._20, UIConstants._20, UIConstants._50, UIConstants._10);
            lastName.add(new Label("Last Name"), 1, 0);
            lastName.add(view.lastName, 2, 0);

            BaseHgrid firstName = new BaseHgrid(UIConstants._20, UIConstants._20, UIConstants._50, UIConstants._10);
            firstName.add(new Label("First Name"), 1, 0);
            firstName.add(view.firstName, 2, 0);

            BaseHgrid number = new BaseHgrid(UIConstants._20, UIConstants._20, UIConstants._50, UIConstants._10);
            number.add(new Label("Number"), 1, 0);
            number.add(view.number, 2, 0);

            view.add(lastName, 0, 0);
            view.add(firstName, 0, 1);
            view.add(number, 0, 2);
            return view;
        }
    }

}