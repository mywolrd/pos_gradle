package pos.application;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import pos.application.resource.Resources;

@Component
public class MainApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Resources resources = null;

        try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml")) {
            resources = ctx.getBean(Resources.class);
            resources.initializeUI();

            Pane root = resources.getRootPane();

            Scene scene = new Scene(root, 1366, 768);

            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}