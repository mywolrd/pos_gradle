package pos.application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane gridPane = new GridPane();

        Scene scene = new Scene(gridPane, 300, 300);

        primaryStage.setTitle("Hello");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}