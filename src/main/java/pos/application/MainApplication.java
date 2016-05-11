package pos.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pos.javafx.UIElementBuilder;
import pos.javafx.button.ItemMenuButton;
import pos.javafx.pane.ItemMenuPane;

@Component
public class MainApplication extends Application {

    @Autowired
    private UIElementBuilder uiElementBuilder;

    @Override
    public void start(Stage primaryStage) throws Exception {

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        List<ItemMenuButton> itemMenuButtons = ctx.getBean(UIElementBuilder.class).listItemMenuButtons();
        ItemMenuPane itemMenuPane = new ItemMenuPane.ItemMenuPaneBuilder(itemMenuButtons).build();

        Scene scene = new Scene(itemMenuPane, 700, 700);

        primaryStage.setTitle("Hello");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}