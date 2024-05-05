package us.bitcash.waybit.waybitfrontendlogin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import us.bitcash.waybit.backend.Customer;
import us.bitcash.waybit.backend.Session;
import us.bitcash.waybit.backend.SessionService;
import us.bitcash.waybit.backend.Status;

public class LoginController {
    private Session session;
    private Stage stage;

    public void setSession(Session s) {
        this.session = s;
    }
    public void setStage(Stage s) {this.stage = s;}
    @FXML
    private Button login;
    @FXML
    private Button register;
    @FXML
    private TextField emailInput;
    @FXML
    private PasswordField passwordInput;

    public void loginButton(ActionEvent event) {

        switch (SessionService.attemptLogin(session,new Customer.CustomerCredentials(
                emailInput.getText(),
                passwordInput.getText()
        ))) {
            case INCORRECT -> new Alert(Alert.AlertType.ERROR,"The credentials provided were incorrect, please try again.",ButtonType.OK).show();
            case FAILURE -> new Alert(Alert.AlertType.ERROR,"Login attempt failed. Please ensure the email you typed followed the format of: a-z_-@a-z-.a-z",ButtonType.OK).show();
            case SUCCESS -> {
                //move on
                stage.close();
                //function that

            }
        }
    }

    public void registerButton(ActionEvent event) {
        Status s = SessionService.attemptRegistration(session,new Customer.CustomerCredentials(
                emailInput.getText(),
                passwordInput.getText()
        ));

        System.out.println(s);
    }


}
