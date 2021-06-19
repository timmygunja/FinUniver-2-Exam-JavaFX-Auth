package sample.models;

import javafx.beans.property.*;


public class User {

    private final StringProperty login; // Связь с данными человека
    private final StringProperty password;

    public User(String login, String password) {
        this.login = new SimpleStringProperty(login);
        this.password = new SimpleStringProperty(password);
    }

    // Основные гетеры

    public String getLogin() {
        return login.get();
    }

    public String getPassword() {
        return password.get();
    }

    // Сетеры

    public void setLogin(String login) {
        this.login.set(login);
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    // Побочные гетеры

    public StringProperty getLoginProperty() {
        return login;
    }

    public StringProperty getPasswordProperty() {
        return password;
    }

}
