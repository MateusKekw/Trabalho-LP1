module com.example.lp1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;

    opens application to javafx.fxml;

}