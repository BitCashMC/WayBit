module us.bitcash.waybit.frontend {
    requires javafx.controls;
    requires javafx.fxml;


    opens us.bitcash.waybit.frontend.live to javafx.fxml;
    exports us.bitcash.waybit.frontend.live;
}