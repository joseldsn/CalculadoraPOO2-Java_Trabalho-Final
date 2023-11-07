module calculator.gui {
    requires javafx.controls;
    requires javafx.fxml;


    opens calculator.gui to javafx.fxml;
    exports calculator.gui;
}