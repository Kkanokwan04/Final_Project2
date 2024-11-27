package edu.sdccd.cisc191;

import javafx.scene.control.Alert;

import java.awt.print.Book;

public class Controller {

    private final BookManager model;
    private final ScreenView view;

    public Controller(BookManager model, ScreenView view) {
        this.model = model;
        this.view = view;

        model.setBookLoaded(() ->{
            view.getListView().setItems(model.getBooks());
        });

        view.getListView().setItems(model.getBooks());

        view.getAddButton().setOnAction(e -> addBook(new BookOrder("")));
        view.getDeleteButton().setOnAction(e -> deleteBook(new BookOrder("")));
        view.getSortButton().setOnAction(e -> sortBooks());
    }

    private void addBook(BookOrder order) {
        String bookName = view.getTextField().getText();
        if(!bookName.isEmpty()){
            model.addBook(new BookOrder(bookName));
            view.getListView().setItems(model.getBooks());
            view.getTextField().clear();
        }
    }

    private void deleteBook(BookOrder order) {
        BookOrder selectedBook = view.getListView().getSelectionModel().getSelectedItem();
        if(selectedBook != null){
            model.removeBook(selectedBook);
            view.getListView().setItems(model.getBooks());
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.showAndWait();
        }
    }

    private void sortBooks(){
        model.sortBookByName();
        view.getListView().setItems(model.getBooks());
    }
}
