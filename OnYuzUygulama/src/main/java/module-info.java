module com.emirozturk.onyuzuygulama {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.emirozturk.onyuzuygulama to javafx.fxml;
    exports com.emirozturk.onyuzuygulama;
}