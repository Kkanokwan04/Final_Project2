package edu.sdccd.cisc191;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ScreenView {
    private TextField textField;
    private Button addButton;
    private Button deleteButton;
    private Button sortButton;
    private ListView<BookOrder> listView;


    public ScreenView(Stage stage) {
        VBox root = new VBox();

        textField = new TextField();
        textField.setId("textField");

        addButton = new Button("Add");
        deleteButton = new Button("Delete");
        sortButton = new Button("Sort");
        listView = new ListView<>();

        root.getChildren().addAll(textField, addButton, deleteButton, sortButton, listView);

        Scene scene = new Scene(root, 300, 400);
        stage.setTitle("Screen View");
        stage.setScene(scene);
        stage.show();

    }

    public TextField getTextField() {return textField;}

    public Button getAddButton() { return addButton; }

    public Button getDeleteButton() { return deleteButton; }

    public Button getSortButton() { return sortButton; }

    public ListView<BookOrder> getListView() { return listView; }


}
