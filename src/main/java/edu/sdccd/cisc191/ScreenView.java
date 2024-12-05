package edu.sdccd.cisc191;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Represents the graphical user interface (GUI) for managing books in a library system.
 * Provides a text field for input, buttons for adding, deleting, and sorting books,
 * and a list view to display the collection of books.
 */
public class ScreenView {

    /**
     * TextField for entering the name of a book.
     */
    private TextField textField;

    /**
     * Button for adding a new book to the library.
     */
    private Button addButton;

    /**
     * Button for deleting a selected book from the library.
     */
    private Button deleteButton;

    /**
     * Button for sorting the books alphabetically by name.
     */
    private Button sortButton;

    /**
     * ListView for displaying the collection of books.
     */
    private ListView<BookOrder> listView;

    /**
     * Constructs a {@code ScreenView} object and initializes the user interface.
     *
     * @param stage the primary {@link Stage} for this view
     */
    public ScreenView(Stage stage) {
        VBox root = new VBox(); // Layout container for arranging UI elements vertically

        // Initialize the text field for book input
        textField = new TextField();
        textField.setId("textField");

        // Initialize the buttons for various actions
        addButton = new Button("Add");
        deleteButton = new Button("Delete");
        sortButton = new Button("Sort");

        // Initialize the ListView for displaying books
        listView = new ListView<>();

        // Add all UI elements to the layout
        root.getChildren().addAll(textField, addButton, deleteButton, sortButton, listView);

        // Create and set the scene for the stage
        Scene scene = new Scene(root, 300, 400);
        stage.setTitle("Library Book Search");
        stage.setScene(scene);
        stage.show();

    }

    /**
     * Gets the text field for entering book names.
     *
     * @return the {@link TextField} object
     */
    public TextField getTextField() {return textField;}

    /**
     * Gets the button for adding books.
     *
     * @return the {@link Button} object for adding books
     */
    public Button getAddButton() { return addButton; }

    /**
     * Gets the button for deleting books.
     *
     * @return the {@link Button} object for deleting books
     */
    public Button getDeleteButton() { return deleteButton; }

    /**
     * Gets the button for sorting books alphabetically.
     *
     * @return the {@link Button} object for sorting books
     */
    public Button getSortButton() { return sortButton; }

    /**
     * Gets the list view for displaying the collection of books.
     *
     * @return the {@link ListView} object containing {@link BookOrder} items
     */
    public ListView<BookOrder> getListView() { return listView; }


}
