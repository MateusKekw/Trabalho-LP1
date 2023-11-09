module com.example.lp1v03 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires java.naming;



    opens com.example.lp1v03 to javafx.fxml;
    exports com.example.lp1v03;
    exports com.example.lp1v03.Controller;
    opens com.example.lp1v03.Controller to javafx.fxml;
}