package edu.sdccd.cisc191;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The entry point for the JavaFX application.
 * Initializes the database, the model, the view, and the controller, and launches the application.
 */
public class Server extends Application {

    /**
     * Starts the JavaFX application.
     * Sets up the database, initializes the MVC components (Model, View, Controller),
     * and displays the main application window.
     *
     * @param primaryStage the primary {@link Stage} for this application
     * @throws Exception if an error occurs during application startup
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create the "Book" table in the database if it doesn't already exist
        DatabaseConnection.createBookTable();

        // Initialize the model (BookManager)
        BookManager model = new BookManager();

        //Initialize the view (ScreenView)
        ScreenView view = new ScreenView(primaryStage);

        // Connect the model and view through the controller
        new Controller(model, view);
    }

    /**
     * The main method serves as the application entry point.
     * It launches the JavaFX application.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
