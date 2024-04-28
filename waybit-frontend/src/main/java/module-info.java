module us.bitcash.waybit.frontend {
    requires javafx.controls;
    requires javafx.fxml;


    exports us.bitcash.waybit.frontend;
    opens us.bitcash.waybit.frontend to javafx.fxml;
}