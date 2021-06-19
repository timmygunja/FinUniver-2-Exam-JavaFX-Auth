package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.Main;
import sample.models.User;

public class MainController {
    private Main main;

    @FXML
    private TableView<User> userTableView;

    @FXML
    private TableColumn<User, String> loginColumn;

    public void setUserTableView(TableView<User> userTableView) {
        this.userTableView = userTableView;
    }

    public MainController() {
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param main
     */
    public void setMainApp(Main main) {
        this.main = main;

        // Add observable list data to the table
        userTableView.setItems(main.getUserData());
    }

    @FXML
    public void initialize(){
        // Инициализация таблицы адресатов с одним столбцом.
        loginColumn.setCellValueFactory(cellData -> cellData.getValue().getLoginProperty());

        // Заполнение таблицы случайными данными
        userTableView.setItems(Main.GenerateUsers());

        // Очистка дополнительной информации об адресате.
//        showPersonDetails(null);

        // Слушаем изменения выбора, и при изменении отображаем
        // дополнительную информацию об адресате.
//        userTableView.getSelectionModel().selectedItemProperty().addListener(
//                (observable, oldValue, newValue) -> showPersonDetails(newValue));
    }

    @FXML
    private Button registerButton;

    @FXML
    private Button signInButton;


    public void mainRegisterButton(ActionEvent actionEvent) {
        System.out.println("Главная - регистрация");
    }

    public void mainSignInButton(ActionEvent actionEvent) {
        System.out.println("Главная - вход");
    }

}
