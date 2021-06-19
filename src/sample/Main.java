package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sample.controllers.MainController;
import sample.models.User;

import java.io.IOException;
import java.util.Random;

public class Main extends Application {
    private ObservableList<User> userData = FXCollections.observableArrayList();
    private Stage primaryStage;
    private BorderPane rootLayout;

    public ObservableList<User> getUserData() {
        return userData;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Приложение авторизации");

        initRootLayout();
        showPersonOverview();
    }

    public Main() {
        for (int i = 0; i < 15; i++) {
            Random random = new Random();
            userData.add(new User("Login " + i, "Password " + random.nextInt(30)));
        }
    }

    public static ObservableList<User> GenerateUsers() {
        final Random random = new Random();
        ObservableList<User> users = FXCollections.observableArrayList();

        for (int i = 1; i <= 15; i++) {
            users.add(new User("Login " + i, "Password " + random.nextInt(30)));
        }

        return users;
    }

    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("views/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showPersonOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("views/Main.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(personOverview);
            MainController PController = loader.getController();
            PController.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        launch(args);
    }
}
