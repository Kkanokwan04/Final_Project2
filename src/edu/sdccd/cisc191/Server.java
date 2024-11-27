package edu.sdccd.cisc191;

import javafx.application.Application;
import javafx.stage.Stage;

public class Server extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        DatabaseConnection.createBookTable();
        BookManager model = new BookManager();
        ScreenView view = new ScreenView(primaryStage);
        new Controller(model, view);

    }
    public static void main(String[] args) {
        launch(args);
    }
}
