module com.example.calculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.commons.lang3;
    requires javaluator;


    opens com.example.calculator to javafx.fxml;
    exports com.example.calculator;
}