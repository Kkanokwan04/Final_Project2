package edu.sdccd.cisc191;

import javafx.scene.control.Alert;

/**
 * The Controller class connects the {@link BookManager} model with the {@link ScreenView} view.
 * It handles user actions from the view and updates the model accordingly.
 */
public class Controller {

    /**
     * The model that manages the library's book data.
     */
    private final BookManager model;

    /**
     * The view that displays the user interface.
     */
    private final ScreenView view;

    /**
     * Constructs a {@code Controller} to handle interactions between the model and view.
     * Initializes event handlers for UI buttons.
     *
     * @param model the {@link BookManager} managing the book data
     * @param view the {@link ScreenView} managing the user interface
     */
    public Controller(BookManager model, ScreenView view) {
        this.model = model;
        this.view = view;

        // Set a callback to update the view when books are loaded
        model.setBookLoaded(() ->{
            view.getListView().setItems(model.getBooks());
        });

        // Initialize the ListView with books from the model
        view.getListView().setItems(model.getBooks());

        // Set event handlers for buttons
        view.getAddButton().setOnAction(e -> addBook(new BookOrder("")));
        view.getDeleteButton().setOnAction(e -> deleteBook(new BookOrder("")));
        view.getSortButton().setOnAction(e -> sortBooks());
    }

    /**
     * Handles the action of adding a new book to the library.
     * Reads the book name from the text field and updates the model and view.
     *
     * @param order a placeholder {@link BookOrder} object (not used directly)
     */
    private void addBook(BookOrder order) {
        String bookName = view.getTextField().getText();
        if(!bookName.isEmpty()){

            // Add the book to the model
            model.addBook(new BookOrder(bookName));

            //Update the ListView
            view.getListView().setItems(model.getBooks());

            //Clear the text field
            view.getTextField().clear();
        }
    }

    /**
     * Handles the action of deleting a selected book from the library.
     * If no book is selected, a warning alert is displayed.
     *
     * @param order a placeholder {@link BookOrder} object (not used directly)
     */
    private void deleteBook(BookOrder order) {
        // Get the selected book from the ListView
        BookOrder selectedBook = view.getListView().getSelectionModel().getSelectedItem();
        if(selectedBook != null){
            // Remove the book from the model
            model.removeBook(selectedBook);

            //Update the ListView
            view.getListView().setItems(model.getBooks());
        }
        else{
            //Show a warning alert if no book is selected
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.showAndWait();
        }
    }

    /**
     * Handles the action of sorting the books in alphabetical order.
     * Updates the ListView to display the sorted list.
     */
    private void sortBooks(){
        // Sort the books in the model
        model.sortBookByName();

        // Update the ListView with the sorted books
        view.getListView().setItems(model.getBooks());
    }
}
