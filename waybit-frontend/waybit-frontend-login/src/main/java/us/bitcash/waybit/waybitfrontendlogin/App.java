package us.bitcash.waybit.waybitfrontendlogin;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import us.bitcash.waybit.backend.Customer;
import us.bitcash.waybit.backend.Session;
import us.bitcash.waybit.backend.SessionService;

import java.io.IOException;

public class App extends Application {

    Session backend;
    @Override
    public void start(Stage stage) throws IOException {

        backend = SessionService.createSession();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);

        LoginController controller = loader.getController();
        controller.setSession(backend);
        controller.setStage(stage);
        stage.show();

    }

    public static void main(String[] args) {

        launch();
    }
}