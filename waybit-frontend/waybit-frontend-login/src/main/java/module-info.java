module us.bitcash.waybit.waybitfrontendlogin {
    requires javafx.controls;
    requires javafx.fxml;
    requires us.bitcash.waybit.backend;


    opens us.bitcash.waybit.waybitfrontendlogin to javafx.fxml;
    exports us.bitcash.waybit.waybitfrontendlogin;
}