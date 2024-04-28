package us.bitcash.waybit.frontend;

import javafx.fxml.FXML;
import javafx.scene.control.TitledPane;

public class LoginController {

    @FXML
    public void initialize() {
        titledPane.setCollapsible(false);
    }

    @FXML
    private TitledPane titledPane;
}
