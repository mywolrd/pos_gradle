package pos.javafx.application;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

@Component
public class MainApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Resources resources = null;

        try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml")) {
            resources = ctx.getBean(Resources.class);
            resources.initializeUI();

            Scene scene = new Scene(resources.getRootView(), 1366, 768);

            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}