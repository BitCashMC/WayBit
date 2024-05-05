module masteringjfx.waybitfrontendmediaplayer {
    requires javafx.controls;
    requires javafx.fxml;
    requires us.bitcash.waybit.backend;


    opens masteringjfx.waybitfrontendmediaplayer to javafx.fxml;
    exports masteringjfx.waybitfrontendmediaplayer;
}